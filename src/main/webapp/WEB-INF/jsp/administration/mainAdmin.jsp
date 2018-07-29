<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>Add Elements</title>
<script language="javascript">
function clearfields()
{
	document.f1.orderList.value ="";
	document.f1.text.value = "";
	document.f1.eleUrl.value = "";
	document.f1.eleId.value = "";
	document.f1.rootId.value = "";
	document.f1.leaf.checked = true;
	document.f1.leaf.readonly=true;
}
function clearTopFileds()
{
	document.f1.orderOfTrees.innerHTML='';
	document.f1.orderOfTrees.disabled = true;
	for ( var i = 0; i < document.f1.operation.length; i++) {
		document.f1.operation[i].checked= false;
	}
}
	function loadAccordians(ele) {
		clearfields();
		document.getElementById('accdId').innerHTML = '';
		document.getElementById('treeRoots').innerHTML = '';
		
		clearTopFileds();
		
		var selected = ele.options[ele.selectedIndex].value;
		var url = 'loadAccordians.do?panelId=' + selected;
		sendRequest('GET', url, 'accdId');
	}
	function loadTreesRoots(ele) {
		clearfields();
		
		clearTopFileds();
		var selected = ele.options[ele.selectedIndex].value;
		var url = 'loadTreeRoots.do?accdId=' + selected;
		sendRequest('GET', url, 'treeRoots');
	}
	function loadTreesElements(ele) {
		clearfields();
		
		clearTopFileds();
		
		var selected = ele.options[ele.selectedIndex].value;
		var url = 'loadTreeElements.do?treeRootId=' + selected;
		sendRequest('GET', url, 'orderOfTrees');
	}
	function loadTreeElement(ele) {
		clearfields();
		var selected = ele.options[ele.selectedIndex].value;
		var url = 'loadTreeElement.do?eleId=' + selected;
		sendRequest('GET', url, 'orderOfTrees',onTreeElementLoad);
	}
	function disableTexts() {
		if (document.f1.leaf.checked) {
			document.f1.name.disabled = false;
			document.f1.eleUrl.disabled = false;
		} else {
			document.f1.name.value = "";
			document.f1.eleUrl.value = "";
			document.f1.name.disabled = true;
			document.f1.eleUrl.disabled = true;
		}
	}
	function getAction() {
		for ( var i = 0; i < document.f1.operation.length; i++) {
			if (document.f1.operation[i].checked) {
				var rad_val = document.f1.operation[i].value;
				return rad_val;
			}
		}
	}
	function disableTreeElements() {
		for ( var i = 0; i < document.f1.operation.length; i++) {
			if (document.f1.operation[i].checked) {
				var rad_val = document.f1.operation[i].value;
				document.f1.submitBtn.value = rad_val;
				if (rad_val == 'ADD') {
					document.f1.orderOfTrees.selectedIndex =-1;
					document.f1.orderOfTrees.disabled = true;
					clearfields();
					document.f1.rootId.value = document.f1.treeRoots.options[document.f1.treeRoots.selectedIndex].value;
					document.f1.eleId.value = -1;
				} else {
					document.f1.orderOfTrees.disabled = false;
				}
			}
		}

	}
	function onTreeElementLoad() {
		var respObj = eval('(' + this.response + ')');
		document.f1.orderList.value = respObj.treeElement.orderList;
		document.f1.text.value = respObj.treeElement.text;
		document.f1.eleUrl.value = respObj.treeElement.eleUrl;
		document.f1.leaf.checked = true;
		document.f1.leaf.readonly=true;
		document.f1.eleId.value = respObj.treeElement.eleId;
		document.f1.rootId.value = respObj.treeElement.rootId;
	}
	function sendRequest(method, url, eleId, f) {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

				if (f)
					f.call(xmlhttp);
				else
					document.getElementById(eleId).innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open(method, url, true);
		xmlhttp.send();
	}
</script>
</head>

<body>
	<form name="f1" action="createElement.do" method="post">
		<div align="center">
			<table border="0"
				style="font-family: Tahoma; font-size: 12pt" width="1009" height="514">
				<tr>
					<td height="24" width="107">Left/Right</td>
					<td height="24" width="611"><select size="1" name="panels"
						onchange="loadAccordians(this)">
							<option selected>Choose One</option>
							<option value="1">Left</option>
							<option value="2">Right</option>
					</select></td>
					<td height="510" width="288" rowspan="11">
					<p align="center">Choose Tree Element</p>
					<p align="center">&nbsp;<select size="29"
						id="orderOfTrees" name="orderOfTrees" multiple
						onchange="loadTreeElement(this)" disabled>
					</select></td>
				</tr>
				<tr>
					<td height="24" width="107">Accordian</td>
					<td height="24" width="611"><select size="1" name="accdId"
						id="accdId" onchange="loadTreesRoots(this)">
					</select></td>
				</tr>
				<tr>
					<td height="24" width="107">Tree</td>
					<td height="24" width="611"><select size="1" name="treeRoots"
						id="treeRoots" onchange="loadTreesElements(this)">
					</select></td>
				</tr>
				<tr>
					<td height="100" width="107">Operation</td>
					<td height="100" width="611">
					<input type="radio" value="ADD"
						name="operation" onclick='disableTreeElements()' checked>Add
						<p>
						<input type="radio" value="UPDATE" name="operation"
								onclick='disableTreeElements()'>Update
						(Choose your tree element to update --&gt;)</p>
						<p>
						<input type="radio" value="DELETE" name="operation"
								onclick='disableTreeElements()'>Delete (Choose 
						your tree element to delete --&gt;)</td>
					</tr>
				<tr>
					<td height="113" width="711" colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td height="24" width="105">Name</td>
					<td height="24" width="611">
					<input type="text" name="text" id="titleText"
						name="text" size="85"></td>
				</tr>
				<tr>
					<td height="24" width="107">URL</td>
					<td height="24" width="611">
					<input type="text" id="eleUrl"
						name="eleUrl" size="85"></td>
				</tr>
				<tr>
					<td height="24" width="107">Order</td>
					<td height="24" width="611">
					<input type="text" id ="orderList"
						name="orderList" size="20"></td>
				</tr>
				<tr>
					<td height="22" width="107">Is Leaf</td>
					<td height="22" width="611"><input
						type="checkbox" name="leaf" value="1" checked id="leaf"
						onclick="disableTexts()"></td>
				</tr>
				<tr>
					<td height="24" width="107">Secret Code</td>
					<td height="24" width="611">
					<input type="text"
						name="secretCode" size="85" value="GopiDaughter"></td>
				</tr>
				<tr>
					<td height="87" width="107">&nbsp;</td>
					<td height="87" width="611"><input type="submit" id="submitBtn" name="submitBtn"
						value="Submit" name="B3"> <input type="reset" value="Reset"
						name="B2"></td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="eleId">
		<input type="hidden" name="rootId">
	</form>

</body>

</html>