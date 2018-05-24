<!DOCTYPE HTML>
<%-- jsf:pagecode language="java" location="/src/pagecode/Anasayfa.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
		
	

<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title>Anasayfa</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9">
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body background="a.jpg" >
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
				<table width="50%" bgcolor="black">
					<tbody>
						<tr>
							<td align="center" bgcolor="white"><b><hx:outputLinkEx style="color:#FF4040;" id="linkEx1" styleClass="outputLinkEx" value="/GYM_OTOMASYON/faces/KullaniciEkle.jsp">
									<h:outputText id="text1" styleClass="outputText" value="Kullanici Ekle"></h:outputText>
								</hx:outputLinkEx></b></td>
							<td align="center" bgcolor="white"><b><hx:outputLinkEx style="color:#FF4040;" id="linkEx2" styleClass="outputLinkEx" value="/GYM_OTOMASYON/faces/TarifeEkle.jsp">
									<h:outputText id="text2" styleClass="outputText" value="Tarife Ekle"></h:outputText>
								</hx:outputLinkEx></b></td>
							<td align="center" bgcolor="white"><b><hx:outputLinkEx style="color:#FF4040;" id="linkEx3" styleClass="outputLinkEx" value="/GYM_OTOMASYON/faces/KartOkut.jsp">
									<h:outputText id="text3" styleClass="outputText" value="Kart Okut"></h:outputText>
								</hx:outputLinkEx></b></td>
							<td align="center" bgcolor="white"><b><hx:outputLinkEx style="color:#FF4040;" id="linkEx4" styleClass="outputLinkEx" value="/GYM_OTOMASYON/faces/KimlerAktif.jsp">
									<h:outputText id="text4" styleClass="outputText" value="Kimler Aktif?"></h:outputText>
								</hx:outputLinkEx></b></td><td align="center" bgcolor="white"><b><hx:outputLinkEx id="linkEx5" styleClass="outputLinkEx" value="/GYM_OTOMASYON/faces/Uyeler.jsp">
									<h:outputText id="text5" style="color:#FF4040;" styleClass="outputText" value="Uyeler"></h:outputText>
								</hx:outputLinkEx></b></td><td align="center" bgcolor="white"><b><hx:outputLinkEx id="linkEx6" styleClass="outputLinkEx" value="/GYM_OTOMASYON/faces/UyeDuzenle.jsp">
									<h:outputText id="text6" styleClass="outputText" value="Uye Duzenle" style="color:red;"></h:outputText>
								</hx:outputLinkEx></b></td><td
								align="center" bgcolor="white"><b><hx:outputLinkEx id="linkEx7" styleClass="outputLinkEx" value="/GYM_OTOMASYON/faces/KartKapat.jsp">
									<h:outputText id="text7" styleClass="outputText" value="Kart Kapat" style="color:red;"></h:outputText>
								</hx:outputLinkEx></b></td></tr>
						<tr>
							<td colspan="7" align="center" bgcolor="black"><b><hx:graphicImageEx
										id="imageEx1" styleClass="graphicImageEx"
										value="1283ab467d5e2fb24505b61964ead932.jpg"></hx:graphicImageEx></b></td></tr>
						<tr>
							<td align="center" bgcolor="black" colspan="7"><h:outputText
									id="text8" styleClass="outputText" value="Toplam Kazanc :" style = "color:white;"></h:outputText><h:outputText
									id="text9" styleClass="outputText" value="#{pc_Anasayfa.kazanc}" style = "color:white;"></h:outputText></td>
						</tr>
					</tbody>
				</table>
			</center>
		</hx:scriptCollector>
	</body>
</f:view>
</html>