<!DOCTYPE HTML>
<%-- jsf:pagecode language="java" location="/src/pagecode/TarifeEkle.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title>TarifeEkle</title>
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
			<p></p>
			<center>

				<h:form id="form1" styleClass="form">
					<table border="1" width="50%" bgcolor="white">
						<tbody>
							<tr>
								<td align="center"><hx:outputLinkEx id="linkEx1"
										style="color:#FF4040;" styleClass="outputLinkEx"
										value="KullaniciEkle.jsp">
										<h:outputText id="text1" styleClass="outputText"
											value="Kullanici Ekle"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx id="linkEx2"
										styleClass="outputLinkEx" value="Anasayfa.jsp"
										style="color:#FF4040;">
										<h:outputText id="text2" styleClass="outputText"
											value="Anasayfa"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx id="linkEx3"
										styleClass="outputLinkEx" style="color:#FF4040;"
										value="KartOkut.jsp">
										<h:outputText id="text3" styleClass="outputText"
											value="Kart Okut"></h:outputText>
									</hx:outputLinkEx></td>
								<td align="center"><hx:outputLinkEx id="linkEx4"
										styleClass="outputLinkEx" style="color:#FF4040;"
										value="KimlerAktif.jsp">
										<h:outputText id="text4" styleClass="outputText"
											value="Kimler Aktif ?"></h:outputText>
									</hx:outputLinkEx></td><td align="center"><hx:outputLinkEx
										id="linkEx5" styleClass="outputLinkEx"  style = "color:#FF4040;" value="Uyeler.jsp">
										<h:outputText id="text5" styleClass="outputText"
											value="Uyeler"></h:outputText>
									</hx:outputLinkEx></td>
							</tr>
							<tr>
								<td align="center"><h:outputText id="outtxtTarife" styleClass="outputText"
										value="Tarife Ad :"></h:outputText></td>
								<td colspan="4" align="center"><h:inputText id="intxtTarifeAd"
										styleClass="inputText" size="53"
										value="#{pc_TarifeEkle.tarife_ad}" required="false"></h:inputText></td>
							</tr>
							<tr>
								<td align="center"><h:outputText id="outtxtTutar"
										styleClass="outputText" value="Fiyat :"></h:outputText></td>
								<td align="center" colspan="4"><h:inputText id="text6"
										styleClass="inputText" size="53"
										value="#{pc_TarifeEkle.tarife_fiyat}" required="false"></h:inputText></td>
							</tr>
							<tr>
								<td align="center" colspan="5"><hx:commandExButton type="submit"
										value="Kaydet" id="btnKaydet" styleClass="commandExButton" action="#{pc_TarifeEkle.doBtnKaydetAction}"></hx:commandExButton></td>
				
							</tr>
							<tr>
								<td align="center" colspan="5"><h:outputText
										id="outtxtErrorMessage" styleClass="outputText"
										style="width: 524px" value="#{pc_TarifeEkle.errorMessage}"></h:outputText></td>
							</tr>
						</tbody>
					</table>
				</h:form>
			</center>
		</hx:scriptCollector>
	</body>
</f:view>
</html>