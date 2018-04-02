<html>

<%@page import="com.attributeConstants.ScopeAttributes"%>
<%
	String logonFailStatus = (String) request
			.getAttribute(ScopeAttributes.LOGON_FAIL);
	if (logonFailStatus == null || logonFailStatus.length() <= 0)
		logonFailStatus = "";
%>

<head>
<title>Center Management - Making life simpler</title>
<meta name="keywords" content="Kumon, Instructor, Kumon Student, Ceneter Management, Kumon Kid">
<meta name="description"
	content="Kumon Students Management, Kumon Instructors, Kumon">

<link rel="stylesheet" type="text/css"
	href="extLib/resources/css/ext-all.css">
<script type="text/javascript" src="extLib/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="extLib/ext-all-debug.js"></script>
<link rel="stylesheet" type="text/css" href="sandbox/css/sandbox.css">

<script type="text/javascript" src="logonForm/logonForm.js"></script>

<script type="text/javascript">
	var isShowErrMsg = false;
    function detectBrowser()
    {
	    var browser = navigator.appName;
	    var b_version = navigator.appVersion;
	    var version = parseFloat(b_version);
	    if (browser == "Microsoft Internet Explorer")
	    {
		    isShowErrMsg = true;
	    } else
	    {
		    isShowErrMsg = false;
	    }
    }
    detectBrowser();
    
    Ext
            .onReady(function()
            {
	            if (isShowErrMsg)
		            Ext.MessageBox
		                    .show(
		                    {
		                        title : 'Invalid Execution',
		                        msg : 'This website is best supported in \nFirefox/Safari/Chrome/Opera/NeoPlanet/NetScape/SeaMonkey etc., but not in InternetExplorer',
		                        buttons : Ext.MessageBox.OK,
		                        minWidth : 300,
		                        icon : Ext.MessageBox.QUESTION
		                    });
	            
            })
</script>
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
										id="form-ct">&nbsp;</div></td>
							</tr>
							<tr>
								<td height="46" width="100%" align="center"><jsp:include
										page="/inclusions/shortcuts.jsp"></jsp:include></td>
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
					</div>
				</td>
			</tr>
			<tr>
				<td height="50%" width="100%">
					<div id="feedbackResult"></div>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>

<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-24837526-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>