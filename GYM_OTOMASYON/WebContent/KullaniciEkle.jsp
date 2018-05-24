<!DOCTYPE HTML5>
<%-- jsf:pagecode language="java" location="/src/pagecode/KullaniciEkle.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
<head>
<title>KullaniciEkle</title>
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
					<table border = "1" width="50%"  bgcolor="white">
						<tbody>
							<tr>
								<td align="center"><hx:outputLinkEx style="color:#FF4040;" id="linkEx1"
										styleClass="outputLinkEx" value="Anasayfa.jsp">
										<h:outputText id="text1" styleClass="outputText"
											value="Anasayfa"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx style="color:#FF4040;" id="linkEx2"
										styleClass="outputLinkEx" value="TarifeEkle.jsp">
										<h:outputText id="text2" styleClass="outputText"
											value="Tarife Ekle"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx style="color:#FF4040;" id="linkEx3"
										styleClass="outputLinkEx" value="KartOkut.jsp">
										<h:outputText id="text3" styleClass="outputText"
											value="Kart Okut"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx style="color:#FF4040;" id="linkEx4"
										styleClass="outputLinkEx" value="KimlerAktif.jsp">
										<h:outputText id="text4" styleClass="outputText"
											value="Kimler Aktif ?"></h:outputText>
									</hx:outputLinkEx></td><td align="center"><hx:outputLinkEx
										id="linkEx5" style="color:#FF4040;" styleClass="outputLinkEx" value="Uyeler.jsp">
										<h:outputText id="text5" styleClass="outputText"
											value="Uyeler"></h:outputText>
									</hx:outputLinkEx></td>
							</tr>
							<tr>
								<td><h:outputText id="outtxtName" styleClass="outputText"
										value="Ad Soyad :"></h:outputText></td>
								<td><h:inputText id="intxtAdSoyad" styleClass="inputText"
										value="#{pc_KullaniciEkle.adSoyad}"></h:inputText></td>
								<td><h:outputText id="outtxtYas" styleClass="outputText"
										value="Yas :"></h:outputText></td>
								<td colspan = "2"><h:inputText id="intxtYas" styleClass="inputText"
										value="#{pc_KullaniciEkle.yas}"></h:inputText></td>
							</tr>
							<tr>
								<td colspan="5"><hx:commandExButton type="submit"
										value="Kaydet" id="btnKaydet" styleClass="commandExButton"
										action="#{pc_KullaniciEkle.doBtnKaydetAction}"></hx:commandExButton></td>
							</tr>
							<tr>
								<td colspan = "5" align="center"><h:outputText id="outtxtError"
										styleClass="outputText" style="width: 530px"
										value="#{pc_KullaniciEkle.errorMessage}"></h:outputText></td>							</tr>
						</tbody>
					</table>
				</h:form>
			</center>
		</hx:scriptCollector>
	</body>
</f:view>
</html>