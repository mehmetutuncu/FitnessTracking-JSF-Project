<!DOCTYPE HTML>
<%-- jsf:pagecode language="java" location="/src/pagecode/KartKapat.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title>KartKapat</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9">
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body background="a.jpg">
		<hx:scriptCollector id="scriptCollector1">
<p>
				<br>
			</p>
			<p></p>
			<p></p>
			<p></p>
			<p></p>
			<p></p>
			<p></p>
			<p></p>
			<center>
				<h:form id="form1" styleClass="form">
					<table border="1" width="30%" bgcolor="white">
						<tbody>
							<tr>
								<td colspan="3" align="center"><hx:outputLinkEx
										id="linkEx1" styleClass="outputLinkEx"
										value="/GYM_OTOMASYON/faces/Anasayfa.jsp">
										<h:outputText style="color:red;" id="text1"
											styleClass="outputText" value="Anasayfa"></h:outputText>
									</hx:outputLinkEx></td>
							</tr>
							<tr>
								<td align="center"><h:selectOneMenu id="menu1"
										styleClass="selectOneMenu" style="width: 126px" value="#{pc_KartKapat.kart_id}">
										<f:selectItems value = "#{pc_KartKapat.list_kartlar}" var = "abc" itemValue="#{abc.kart_id}"
											itemLabel="#{abc.kart_id}" />
									</h:selectOneMenu></td>
								<td align="center"><h:outputText id="text2"
										styleClass="outputText" value="#{pc_KartKapat.adSoyad}"></h:outputText></td>
								<td align="center"><hx:commandExButton type="submit"
										value="Getir" id="btnGetir" styleClass="commandExButton" action="#{pc_KartKapat.doBtnGetirAction}"></hx:commandExButton></td>
							</tr>
							<tr>
								<td align="center" colspan="3"><hx:commandExButton type="submit"
										value="DeAktif Et" id="btnDeAktifEt"
										styleClass="commandExButton" action="#{pc_KartKapat.doBtnDeAktifEtAction}"></hx:commandExButton></td>
							</tr>
							<tr>
								<td align="center" colspan="3"><h:outputText id="outtxtMessage"
										styleClass="outputText" value="#{pc_KartKapat.mesaj}"></h:outputText></td>
							</tr>
						</tbody>
					</table>
				</h:form>
			</center>
		</hx:scriptCollector>
	</body>
</f:view>
</html>