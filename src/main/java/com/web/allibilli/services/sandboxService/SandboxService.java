package com.web.allibilli.services.sandboxService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.web.allibilli.attributeConstants.GenericConstants;
import com.web.allibilli.beans.sandbox.AccordiansBean;
import com.web.allibilli.beans.sandbox.PanelsBean;
import com.web.allibilli.beans.sandbox.SandboxBean;
import com.web.allibilli.beans.sandbox.TreeElementsBean;
import com.web.allibilli.services.BaseService;
import com.web.allibilli.utils.Attacher;
import com.web.allibilli.utils.DescribeInstance;

@Service
public class SandboxService extends BaseService {

	private static final Logger logger = LoggerFactory.getLogger(SandboxService.class);

	public Collection<TreeElementsBean> processSubTrees(HashMap<Integer, TreeElementsBean> myRoots) {

		@SuppressWarnings("unchecked")
		HashMap<Integer, TreeElementsBean> roots = (HashMap<Integer, TreeElementsBean>) myRoots.clone();
		//logger.debug("initial Size recieved to process the list " + roots.size());

		Collection<TreeElementsBean> c = myRoots.values();
		List<TreeElementsBean> list = new ArrayList<TreeElementsBean>(c);
		Collections.sort(list, ORDER_LIST_COMP);
		
		int rootId;
		TreeElementsBean nonRootTree;

		// Finding and assigning the the sub roots
		for (TreeElementsBean tBean : list) {
			// logger.debug("Processing ");
			// DescribeInstance.describeInstance(tBean);

			rootId = tBean.getRootId();

			if (roots.containsKey(rootId)) {

				TreeElementsBean rootTree = roots.get(rootId);
				if (rootTree.getChildren() == null) {
					rootTree.setChildren(new ArrayList<TreeElementsBean>());
					rootTree.getChildren().add(tBean);
					//logger.debug("Root found for " + tBean.getText() + " and that is " + rootTree.getText());
				} else {
					rootTree.getChildren().add(tBean);
				}

			}

		}

		// Getting out the top roots
		HashMap<Integer, TreeElementsBean> updatedList = new HashMap<Integer, TreeElementsBean>();

		for (TreeElementsBean tBean : list) {
			// logger.debug("Processing ");
			// DescribeInstance.describeInstance(tBean);

			rootId = tBean.getRootId();

			if (!roots.containsKey(rootId) && !updatedList.containsKey(rootId)) {
				nonRootTree = roots.remove(tBean.getEleId());
				updatedList.put(nonRootTree.getEleId(), nonRootTree);
			}

		}

		return (Collection<TreeElementsBean>) updatedList.values();

	}

	static final Comparator<TreeElementsBean> ORDER_LIST_COMP = new Comparator<TreeElementsBean>() {
		public int compare(TreeElementsBean e1, TreeElementsBean e2) {
			return new Integer(e1.getOrderList()).compareTo(e2.getOrderList());
		}
	};

	static final Comparator<TreeElementsBean> ORDER_LIST_COMP_ = new Comparator<TreeElementsBean>() {
		public int compare(TreeElementsBean e1, TreeElementsBean e2) {
			return new Integer(e1.getOrderList()).compareTo(e2.getOrderList());
		}
	};
	
	public Collection<TreeElementsBean> processTrees(List<TreeElementsBean> treeElems) {

		HashMap<Integer, TreeElementsBean> roots = new HashMap<Integer, TreeElementsBean>();
		HashMap<Integer, TreeElementsBean> leafs = new HashMap<Integer, TreeElementsBean>();

		TreeElementsBean tBean;

		// Separating roots and Leafs

		//Collections.sort(treeElems, ORDER_LIST_COMP_);
		for (int index = 0; index < treeElems.size(); ++index) {
			tBean = treeElems.get(index);
			if (!tBean.getLeaf()) {
				//logger.debug(tBean.getText()+" --> is leaf -->"+tBean.getLeaf());
				roots.put(tBean.getEleId(), tBean);
			} else if (tBean.getRootId() != -1 && tBean.getLeaf()) {
				// logger.debug(tBean.getText()+" --> is leaf -->"+tBean.getLeaf());
				leafs.put(tBean.getEleId(), tBean);
			} else {
				//DescribeInstance.describeInstance(tBean);
			}
		}

		// Adding leafs to their roots

		Collection<TreeElementsBean> c = leafs.values();
		List<TreeElementsBean> list = new ArrayList<TreeElementsBean>(c);
		Collections.sort(list, ORDER_LIST_COMP);
		for (TreeElementsBean lBean : list) {
			if (roots.containsKey(lBean.getRootId())) {

				TreeElementsBean rootNode = roots.get(lBean.getRootId());
				
					//logger.debug(lBean.getText() + " --> is a leaf of -->" + rootNode.getText());

				if (rootNode.getChildren() == null) {
					rootNode.setChildren(new ArrayList<TreeElementsBean>());
					rootNode.getChildren().add(lBean);
				} else {
					rootNode.getChildren().add(lBean);
				}
			}
		}
		Collection<TreeElementsBean> updatedList = processSubTrees(roots);
		return updatedList;
	}

	public String listSandBoxComponents() {

		Map<String, Object> map = sandBoxDAO.listSandboxComponents();
		String jsonString = "";

		if (map.size() > 0) {

			logger.debug("Retriving the list of sandbox components...");

			@SuppressWarnings("unchecked")
			List<PanelsBean> pnls = (List<PanelsBean>) map.get(GenericConstants.LIST_PANELS);
			@SuppressWarnings("unchecked")
			List<AccordiansBean> leftAccBeans = (List<AccordiansBean>) map.get(GenericConstants.LIST_LEFT_ACCORDIANS);
			@SuppressWarnings("unchecked")
			List<AccordiansBean> rightAccBeans = (List<AccordiansBean>) map.get(GenericConstants.LIST_RIGHT_ACCORDIANS);
			@SuppressWarnings("unchecked")
			List<TreeElementsBean> treeElems = (List<TreeElementsBean>) map.get(GenericConstants.LIST_TREE_ELEMENTS);

			HashMap<Integer, AccordiansBean> accMap = Attacher.buildAccordians(leftAccBeans, rightAccBeans);

			SandboxBean bean = new SandboxBean();

			Collection<TreeElementsBean>  c = processTrees(treeElems);

			List<TreeElementsBean> collectionsOfTrees = new ArrayList<TreeElementsBean>(c);
			Collections.sort(collectionsOfTrees, ORDER_LIST_COMP);
			
			for (TreeElementsBean tBean : collectionsOfTrees) {
				Attacher.attachTreeElementToAccordian(accMap, tBean);
			}

			pnls.get(0).setAccs(leftAccBeans);
			pnls.get(1).setAccs(rightAccBeans);

			bean.getPanels().add(pnls.get(0));
			bean.getPanels().add(pnls.get(1));

			jsonString = buildJSON(GenericConstants.SUCCESS_TRUE, GenericConstants.JSON_SANDBOX_COMPONENTS, bean);
		}
		//logger.debug(jsonString);
		return jsonString;
	}
}
