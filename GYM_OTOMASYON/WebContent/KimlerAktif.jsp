<!DOCTYPE HTML>
<%-- jsf:pagecode language="java" location="/src/pagecode/KimlerAktif.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title>KimlerAktif</title>
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
					<table border="1" width="50%" bgcolor="white" height="134">
						<tbody>
							<tr>
								<td align="center"><hx:outputLinkEx id="linkEx1"
										styleClass="outputLinkEx" value="/GYM_OTOMASYON/faces/KullaniciEkle.jsp">
										<h:outputText style="color:#FF4040;" id="text1"
											styleClass="outputText" value="Kullanici Ekle"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx id="linkEx2"
										styleClass="outputLinkEx" value="/GYM_OTOMASYON/faces/TarifeEkle.jsp">
										<h:outputText style="color:#FF4040;" id="text2"
											styleClass="outputText" value="Tarife Ekle"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx style="color:#FF4040;"
										id="linkEx3" styleClass="outputLinkEx" value="/GYM_OTOMASYON/faces/KartOkut.jsp">
										<h:outputText id="text3" styleClass="outputText"
											value="Kart Okut"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx id="linkEx4"
										styleClass="outputLinkEx" style="color:#FF4040;"
										value="/GYM_OTOMASYON/faces/Anasayfa.jsp">
										<h:outputText id="text4" styleClass="outputText"
											value="Anasayfa"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx id="linkEx5"
										styleClass="outputLinkEx" style="color:#FF4040;"
										value="/GYM_OTOMASYON/faces/Uyeler.jsp">
										<h:outputText id="text5" styleClass="outputText"
											value="Uyeler"></h:outputText>
									</hx:outputLinkEx></td>
							</tr>
							<tr>
								<td align="center" colspan="2"><hx:dataTableEx
										id="list_aktifler1" value="#{pc_KimlerAktif.list_aktifler}"
										var="varlist_aktifler" styleClass="dataTableEx"
										headerClass="headerClass" footerClass="footerClass"
										rowClasses="rowClass1, rowClass2" columnClasses="columnClass1"
										border="1" cellpadding="2" cellspacing="0"
										style="width: 192px">
										<hx:columnEx id="kart_id1column" align="center" width="30%">
											<f:facet name="header">
												<h:outputText styleClass="outputText" value="Kart Numarasi"
													id="kart_id1text"></h:outputText>
											</f:facet>
											<h:outputText styleClass="outputText" id="kart_id1"
												value="#{varlist_aktifler.kart_id}">
											</h:outputText>
										</hx:columnEx>
									</hx:dataTableEx></td>
								<td align="center" colspan="2"><hx:dataTableEx
										id="list_aktifler2" value="#{pc_KimlerAktif.list_aktifler}"
										var="varlist_aktifler" styleClass="dataTableEx"
										headerClass="headerClass" footerClass="footerClass"
										rowClasses="rowClass1, rowClass2" columnClasses="columnClass1"
										border="1" cellpadding="2" cellspacing="0"
										style="width: 165px">
										<hx:columnEx id="adSoyad1column" width="30%" align="center"
											style="width: 132px">
											<f:facet name="header">
												<h:outputText styleClass="outputText" value="Ad Soyad"
													id="adSoyad1text"></h:outputText>
											</f:facet>
											<h:outputText styleClass="outputText" id="adSoyad1"
												value="#{varlist_aktifler.adSoyad}">
											</h:outputText>
										</hx:columnEx>
									</hx:dataTableEx></td>
								<td align="center"><hx:dataTableEx id="list_aktifler3"
										value="#{pc_KimlerAktif.list_aktifler}" var="varlist_aktifler"
										styleClass="dataTableEx" headerClass="headerClass"
										footerClass="footerClass" rowClasses="rowClass1, rowClass2"
										columnClasses="columnClass1" border="1" cellpadding="2"
										cellspacing="0" style="width: 189px">
										<hx:columnEx id="yas1column" width="30" align="center">
											<f:facet name="header">
												<h:outputText styleClass="outputText" value="Yas"
													id="yas1text"></h:outputText>
											</f:facet>
											<h:outputText styleClass="outputText" id="yas1"
												value="#{varlist_aktifler.yas}">
											</h:outputText>
										</hx:columnEx>
									</hx:dataTableEx></td>
							</tr>
							<tr>
								<td align="center" colspan="5"><h:outputText id="outtxtMessage"
										styleClass="outputText" value="#{pc_KimlerAktif.mesaj}"></h:outputText></td>
							</tr>
						</tbody>
					</table>
				</h:form>
			</center>
		</hx:scriptCollector>
	</body>
</f:view>
</html>