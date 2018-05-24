<!DOCTYPE HTML>
<%-- jsf:pagecode language="java" location="/src/pagecode/UyeDuzenle.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title>UyeDuzenle</title>
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
					<table border="1" width="20%" bgcolor="white">
						<tbody>
							<tr>
								<td  colspan = "2" align="center"><hx:outputLinkEx id="linkEx1"
										styleClass="outputLinkEx"
										value="/GYM_OTOMASYON/faces/Anasayfa.jsp">
										<h:outputText style="color:red;" id="text1"
											styleClass="outputText" value="Anasayfa"></h:outputText>
									</hx:outputLinkEx></td>
							</tr>
							<tr>
								<td  aign="center" align="center"><h:selectOneMenu id="menu1"
										styleClass="selectOneMenu" style="width: 209px" value="#{pc_UyeDuzenle.uye_id}">
										<f:selectItems  value = "#{pc_UyeDuzenle.list_uyeInfo}" var = "abc" itemValue="#{abc.uye_id}"
											itemLabel="#{abc.adSoyad}" />
									</h:selectOneMenu></td> <td align = "center"><hx:commandExButton
										type="submit" value="Getir" id="btnGetir"
										styleClass="commandExButton"
										action="#{pc_UyeDuzenle.doBtnGetirAction}"></hx:commandExButton></td>
							</tr>
							<tr>
								<td aign="center" align="center"><h:outputText
										id="outTxtAdSoyad" styleClass="outputText"
										style="width: 136px" value="Ad Soyad :"></h:outputText></td><td aign="center"
									align="center"><h:inputText id="inttxtAdSoyad"
										styleClass="inputText" value="#{pc_UyeDuzenle.adSoyad}"></h:inputText></td>
							</tr>
							<tr>
								<td aign="center" align="center"><h:outputText id="outtxtYas"
										styleClass="outputText" style="width: 139px" value="Yas :"></h:outputText></td>
								<td aign="center" align="center"><h:inputText id="inttxtYas"
										styleClass="inputText" value="#{pc_UyeDuzenle.yas}"></h:inputText></td>
							</tr>
							<tr>
								<td aign="center" align="center" colspan="2"><hx:dataTableEx
										id="kullanici_tarife_list1"
										value="#{pc_UyeDuzenle.kullanici_tarife_list}"
										var="varkullanici_tarife_list" styleClass="dataTableEx"
										headerClass="headerClass" footerClass="footerClass"
										rowClasses="rowClass1, rowClass2" columnClasses="columnClass1"
										border="1" cellpadding="2" cellspacing="0">
										<hx:columnEx id="ad1column">
											<f:facet name="header">
												<h:outputText styleClass="outputText" value="Ad"
													id="ad1text"></h:outputText>
											</f:facet>
											<h:outputText styleClass="outputText" id="ad1"
												value="#{varkullanici_tarife_list.ad}">
											</h:outputText>
										</hx:columnEx>
										<hx:columnEx id="ay1column">
											<f:facet name="header">
												<h:outputText styleClass="outputText" value="Ay"
													id="ay1text"></h:outputText>
											</f:facet>
											<h:outputText styleClass="outputText" id="ay1"
												value="#{varkullanici_tarife_list.ay}">
											</h:outputText>
										</hx:columnEx>
										<hx:columnEx id="basTarihi1column">
											<f:facet name="header">
												<h:outputText styleClass="outputText" value="BasTarihi"
													id="basTarihi1text"></h:outputText>
											</f:facet>
											<h:outputText styleClass="outputText" id="basTarihi1"
												value="#{varkullanici_tarife_list.basTarihi}">
											</h:outputText>
										</hx:columnEx>
										<hx:columnEx id="kalanHesap1column">
											<f:facet name="header">
												<h:outputText styleClass="outputText" value="KalanHesap"
													id="kalanHesap1text"></h:outputText>
											</f:facet>
											<h:outputText styleClass="outputText" id="kalanHesap1"
												value="#{varkullanici_tarife_list.kalanHesap}">
											</h:outputText>
										</hx:columnEx>
									</hx:dataTableEx></td></tr>
							<tr>
								<td aign="center" align="center" colspan="2"><hx:commandExButton
										type="submit" value="Guncelle" id="btnGuncelle"
										styleClass="commandExButton"
										action="#{pc_UyeDuzenle.doBtnGuncelleAction}"></hx:commandExButton></td></tr>
							<tr>
								<td aign="center" align="center" colspan="2"><h:outputText
										id="outtxtMessage" styleClass="outputText" value="#{pc_UyeDuzenle.mesaj}"></h:outputText></td></tr>
						</tbody>
					</table>
				</h:form>
			</center>
		</hx:scriptCollector>
	</body>
</f:view>
</html>