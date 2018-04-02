<%
	System.out.println("FORWARDING --> logon.jsp");
	System.out.println("Request Recieved From IP -->" + request.getRemoteAddr());
%>
<jsp:forward page="/WEB-INF/jsp/sandbox/test.jsp"></jsp:forward>
