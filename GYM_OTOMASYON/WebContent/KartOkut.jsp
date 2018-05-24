<!DOCTYPE HTML>
<%-- jsf:pagecode language="java" location="/src/pagecode/KartOkut.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title>KartOkut</title>
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
					<table border="1" width="50%" bgcolor="white">
						<tbody>
							<tr>
								<td align="center"><hx:outputLinkEx style="color:#FF4040;"
										id="linkEx1" styleClass="outputLinkEx"
										value="KullaniciEkle.jsp">
										<h:outputText id="text1" styleClass="outputText"
											value="Kullanici Ekle"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx id="linkEx2"
										styleClass="outputLinkEx" style="color:#FF4040;"
										value="TarifeEkle.jsp">
										<h:outputText id="text2" styleClass="outputText"
											value="Tarife Ekle"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx id="linkEx3"
										styleClass="outputLinkEx" style="color:#FF4040;"
										value="Anasayfa.jsp">
										<h:outputText id="text3" styleClass="outputText"
											value="Anasayfa"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx id="linkEx4"
										styleClass="outputLinkEx" style="color:#FF4040;"
										value="KimlerAktif.jsp">
										<h:outputText id="text4" styleClass="outputText"
											value="Kimler Aktif ?"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx id="linkEx5"
										styleClass="outputLinkEx" style="color:#FF4040;"
										value="Uyeler.jsp">
										<h:outputText id="text5" styleClass="outputText"
											value="Uyeler"></h:outputText>
									</hx:outputLinkEx></td>
							</tr>
							<tr>
								<td colspan = "2" align="center"><h:selectOneMenu
										id="cmbKartlar" styleClass="selectOneMenu"
										style="width: 201px" value="#{pc_KartOkut.kart_id}">
										<f:selectItems value = "#{pc_KartOkut.list_kartlar}" var = "abc" itemLabel = "#{abc.kart_id}" itemValue="#{abc.kart_id}"/>
										</h:selectOneMenu></td>
								<td align="center" colspan = "2"><h:outputText
										id="outtxtAdSoyad" styleClass="outputText"
										style="width: 209px" value="#{pc_KartOkut.adSoyad}"></h:outputText></td>
								<td align="center"><hx:commandExButton type="submit"
										value="Getir" id="btnGetir" styleClass="commandExButton" action="#{pc_KartOkut.doBtnGetirAction}"></hx:commandExButton></td>
							</tr>
							<tr>
								<td align="center" colspan="5"><hx:commandExButton type="submit"
										value="Aktif Et" id="btnAktifEt" styleClass="commandExButton" action="#{pc_KartOkut.doBtnAktifEtAction}"></hx:commandExButton></td>
							</tr>
							<tr>
								<td align="center" colspan="5"><h:outputText id="outtxtError"
										styleClass="outputText" value="#{pc_KartOkut.mesaj}"></h:outputText></td>
							</tr>
						</tbody>
					</table>
				</h:form>
			</center>
		</hx:scriptCollector>
	</body>
</f:view>
</html>