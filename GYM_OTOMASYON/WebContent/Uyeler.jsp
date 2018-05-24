<!DOCTYPE HTML>
<%-- jsf:pagecode language="java" location="/src/pagecode/Uyeler.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title>Uyeler</title>
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
			<br>

			<center>
				<h:form id="form1" styleClass="form">
					<table border= "2" width= "40%" bgcolor= "white">
						<tbody>
							<tr>
								<td align="center" height="47"><hx:outputLinkEx id="linkEx1"
										styleClass="outputLinkEx"
										value="/GYM_OTOMASYON/faces/KullaniciEkle.jsp">
										<h:outputText id="text1" styleClass="outputText"
											style="color:#FF4040;" value="Kullanici Ekle"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center" height="47"><hx:outputLinkEx id="linkEx2"
										styleClass="outputLinkEx"
										value="/GYM_OTOMASYON/faces/TarifeEkle.jsp"
										style="color:#FF4040;">
										<h:outputText id="text2" styleClass="outputText"
											value="Tarife Ekle"></h:outputText>
									</hx:outputLinkEx></td>
								<td colspan="2" align="center" height="47"><hx:outputLinkEx
										id="linkEx3" styleClass="outputLinkEx"
										value="/GYM_OTOMASYON/faces/KartOkut.jsp"
										style="color:#FF4040;">
										<h:outputText id="text3" styleClass="outputText"
											value="Kart Okut"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center" style="height: 47px" height="47"><hx:outputLinkEx
										id="linkEx4" styleClass="outputLinkEx" style="color:#FF4040;"
										value="/GYM_OTOMASYON/faces/KimlerAktif.jsp">
										<h:outputText id="text4" styleClass="outputText"
											value="Kimler Aktif ?"></h:outputText>
									</hx:outputLinkEx></td>
								<td colspan="3" align="center" height="47"><hx:outputLinkEx
										id="linkEx5" styleClass="outputLinkEx" style="color:#FF4040;"
										value="/GYM_OTOMASYON/faces/Anasayfa.jsp">
										<h:outputText id="text5" styleClass="outputText"
											value="Anasayfa"></h:outputText>
									</hx:outputLinkEx></td>
							</tr>
							<tr>
								<td align="center" colspan="8" height="195"><hx:dataTableEx
										id="kullaniciBeanList1" value="#{pc_Uyeler.kullaniciBeanList}"
										var="varkullaniciBeanList" styleClass="dataTableEx"
										headerClass="headerClass" footerClass="footerClass"
										rowClasses="rowClass1, rowClass2" columnClasses="columnClass1"
										border="1" cellpadding="2" cellspacing="0">
										<hx:columnEx id="kartId1column">
											<f:facet name="header">
												<h:outputText styleClass="outputText" value="KartId"
													id="kartId1text"></h:outputText>
											</f:facet>
											<h:outputText styleClass="outputText" id="kartId1"
												value="#{varkullaniciBeanList.kartId}">
											</h:outputText>
										</hx:columnEx>
										<hx:columnEx id="adSoyad1column">
											<f:facet name="header">
												<h:outputText styleClass="outputText" value="AdSoyad"
													id="adSoyad1text"></h:outputText>
											</f:facet>
											<hx:requestLink id="link1" styleClass="requestLink" action="#{pc_Uyeler.ekle}">
												<h:outputText id="text6" styleClass="outputText"
													value="#{varkullaniciBeanList.adSoyad}"></h:outputText>
												<f:param value="#{varkullaniciBeanList.uye_id}" id="param1"
													name="uye_id"></f:param>
											</hx:requestLink>
										</hx:columnEx>
										<hx:columnEx id="yas1column">
											<f:facet name="header">
												<h:outputText styleClass="outputText" value="Yas"
													id="yas1text"></h:outputText>
											</f:facet>
											<h:outputText styleClass="outputText" id="yas1"
												value="#{varkullaniciBeanList.yas}">
											</h:outputText>
										</hx:columnEx>
									</hx:dataTableEx></td>
							</tr>
						</tbody>
					</table>
				</h:form>
			</center>
		</hx:scriptCollector>
	</body>
</f:view>
</html>