<%@page import="com.attributeConstants.ScopeAttributes"%>
<%
	String logonFailStatus = (String) request
			.getAttribute(ScopeAttributes.STATUS_MESSAGE);
	if (logonFailStatus == null || logonFailStatus.length() <= 0)
		logonFailStatus = "";
%>
<html>

<head>
<title>Center Management  - Open Source Product from AlliBilli - Making
	life Simpler</title>
<meta name="keywords" content="Kumon, Instructor, Kumon Student">
<meta name="description"
	content="Kumon Students Management by Kumon Instructors. An Open Source Project.">

</head>
<body bgcolor="#000000" topmargin="0" leftmargin="0" link="#808080"
	vlink="#008080" alink="#008080">

	<div align="center">
		<table border="0" width="100%" height="100%"
			style="font-family: Tahoma; font-size: 10pt">
			<tr>
				<td width="100%">&nbsp;</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						<table border="0" width="100%" height="100%">
							<tr>
								<td height="26" width="100%" align="center"><jsp:include
										page="/inclusions/header.jsp"></jsp:include></td>
							</tr>
							<tr>
								<td height="22" width="100%" align="center"></td>
							</tr>
							<tr>
								<td height="26" width="100%" align="center"><font
									style="color: #FF0000; font-family: Tahoma; font-size: 10pt"><%=logonFailStatus%></font>
								</td>
							</tr>
							<tr>
								<td height="26" width="100%" align="center"><div
										id="form-ct">
										<form method="POST" action="forgotPassword.do" method="post">
											<table border="0" width="271" height="106"
												style="font-family: Tahoma; font-size: 9pt; color: #FFFFFF">
												<tr>
													<td height="30" width="92" align="right"><b> <font
															color="#808080">Logon Name</font>
													</b>
													</td>
													<td height="30" width="6" align="center"><b> <font
															color="#808080">:</font>
													</b>
													</td>
													<td height="30" width="159" align="right">
														<p>
															<b><font size="1" color="#808080"> <input
																	type="text" name="logonName" size="20"
																	style="font-family: Tahoma; font-size: 8pt; color: #808080; border-left-style: solid; border-left-width: 1px; border-right: 1px solid #808080; border-top: 1px solid #808080; border-bottom: 1px solid #808080">
															</font>
															</b>
														</p></td>
												</tr>
												<tr>
													<td height="30" width="92" align="right"><b> <font
															color="#808080">Email Id</font>
													</b>
													</td>
													<td height="30" width="6" align="center"><b> <font
															size="1" color="#808080">:</font>
													</b>
													</td>
													<td height="30" width="159" align="right"><b> <font
															size="1" color="#808080"> <input type="text"
																name="emailId" size="20"
																style="font-family: Tahoma; font-size: 8pt; color: #808080; border: 1px solid #808080">
														</font>
													</b>
													</td>
												</tr>
												<tr>
													<td height="16" width="102" colspan="2"></td>
													<td height="16" width="159" align="justify">
														<p align="right">
															<b><font size="1" color="#808080"> <input
																	type="submit" value="Submit" name="B1"
																	style="font-family: Tahoma; font-size: 8pt; color: #808080">
																	<input type="reset" value="Reset" name="B2"
																	style="font-family: Tahoma; font-size: 8pt; color: #808080">
															</font>
															</b>
													</td>
												</tr>
												<tr>
													<td height="10" width="265" colspan="3">
														<p align="center">
													</td>
												</tr>
											</table>
										</form>
									</div>
								</td>
							</tr>
							<tr>
								<td height="46" width="100%" align="center"><jsp:include
										page="/inclusions/shortcutsNoDemo.jsp"></jsp:include></td>
							</tr>
							<tr>
								<td height="14" width="100%" align="center"></td>
							</tr>
							<tr>
								<td height="12" width="100%" align="center"></td>
							</tr>
							<tr>
								<td height="26" width="100%" align="center">&nbsp;</td>
							</tr>
							<tr>
								<td height="18" width="100%" align="center"><jsp:include
										page="/inclusions/aboveFooter.jsp"></jsp:include></td>
							</tr>
							<tr>
								<td height="41" width="100%" align="center"><jsp:include
										page="/inclusions/footer.jsp"></jsp:include></td>
							</tr>
						</table>
					</div></td>
			</tr>
			<tr>
				<td height="50%" width="100%">&nbsp;</td>
			</tr>
		</table>
	</div>
</html>