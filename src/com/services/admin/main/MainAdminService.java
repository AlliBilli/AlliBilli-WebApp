package com.services.admin.main;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attributeConstants.GenericConstants;
import com.beans.hibernate.Accordians;
import com.beans.hibernate.TreeElements;
import com.services.BaseService;

@Service
public class MainAdminService extends BaseService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(MainAdminService.class);

	public String loadAccordians(int panelId) {
		List<Accordians> l = mainAdminDAO.loadAccordians(panelId);
		StringBuilder b = new StringBuilder();

		for (Accordians bean : l) {
			b.append("<option value=").append(bean.getAccdId()).append(">")
					.append(bean.getAccdName()).append("</option>");
		}
		b.append("<option selected>Choose One</option>");
		return b.toString();

	}

	public String loadTreeRoots(int accdId) {
		List<TreeElements> l = mainAdminDAO.loadTreeRoots(accdId);
		StringBuilder b = new StringBuilder();

		for (TreeElements bean : l) {
			b.append("<option value=").append(bean.getEleId()).append(">")
					.append(bean.getText()).append("</option>");
		}

		return b.toString();

	}

	public String loadTreeElements(int treeRootId) {
		List<TreeElements> l = mainAdminDAO.loadTreeElements(treeRootId);
		StringBuilder b = new StringBuilder();

		for (TreeElements bean : l) {
			b.append("<option value=").append(bean.getEleId()).append(">")
					.append(bean.getText() + " : " + bean.getOrderList())
					.append("</option>");
		}

		return b.toString();

	}

	public String loadTreeElement(int eleId) {
		List<TreeElements> l = mainAdminDAO.loadTreeElement(eleId);

		return buildJSON(GenericConstants.SUCCESS_TRUE,
				GenericConstants.JSON_TREE_ELEMENT, l.get(0));

	}

	public void saveOrUpdateElement(String operation, TreeElements bean) {

		if (operation.equals("ADD")) {
			mainAdminDAO.saveTreeElement(bean);
		} else if (operation.equals("UPDATE")) {
			mainAdminDAO.updateTreeElement(bean);
		} else {
			mainAdminDAO.deleteTreeElement(bean);
		}
	}

	public void saveTreeElement(TreeElements bean) {
		
		mainAdminDAO.saveTreeElement(bean);
//		
//		if(sBean.getEleId()!=-1)
//			return "Deal Done! Please verify in UI";
//		else
//			return "Deal Failed! Contact Sysadmin";
//		

	}

}
