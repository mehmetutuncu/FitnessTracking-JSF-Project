<!DOCTYPE HTML>
<%-- jsf:pagecode language="java" location="/src/pagecode/UyeTarife.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<title>UyeTarife</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9">
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
<script type="text/javascript">
function func_1(thisObj, thisEvent) {
//use 'thisObj' to refer directly to this component instead of keyword 'this'
//use 'thisEvent' to refer to the event generated instead of keyword 'event'
		
}</script></head>
<f:view>
	<body background="a.jpg">
		<hx:scriptCollector id="scriptCollector1">





			<br>
			<br>
			<br>
			<br>
			<br>

			<center>

				<h:form id="form1" styleClass="form">
				<h:inputHidden
										value="#{pc_UyeTarife.uye_id}">
									</h:inputHidden>
					<table width="30%" border="1" bgcolor="white">
						<tbody>
							<tr>
								<td colspan="2"><hx:outputLinkEx id="linkEx1"
										styleClass="outputLinkEx"
										value="/GYM_OTOMASYON/faces/Anasayfa.jsp">
										<h:outputText id="text1" styleClass="outputText"
											value="Anasayfa" style = "color:red;"></h:outputText>
									</hx:outputLinkEx></td></tr>
							<tr>
								<td height="25" style="height: 25px" colspan="2">
								<h:selectOneMenu id="menu1" styleClass="selectOneMenu"
										style="width: 216px" value = "#{pc_UyeTarife.tarife_id}">
										<f:selectItems value = "#{pc_UyeTarife.list_tarifeler}" var = "abc" itemLabel = "#{abc.tarife_ad}" itemValue = "#{abc.tarife_id}"/>										
										</h:selectOneMenu>
								</td></tr>
							<tr>
								<td height="24" colspan="2"><h:selectOneRadio
										disabledClass="selectOneRadio_Disabled"
										enabledClass="selectOneRadio_Enabled" id="radio1"
										styleClass="selectOneRadio" value="#{pc_UyeTarife.deger}">
										<f:selectItem id="selectItem1" itemValue="1" itemLabel="1" />
										<f:selectItem id="selectItem2" itemValue="3" itemLabel="3" />
										<f:selectItem id="selectItem3" itemValue="6" itemLabel="6" />
										<f:selectItem id="selectItem4" itemValue="12" itemLabel="12" />
									</h:selectOneRadio></td></tr>
							<tr>
								<td colspan="2" align="center"><hx:commandExButton type="submit" value="Ekle"
										id="btnEkle" styleClass="commandExButton"
										action="#{pc_UyeTarife.doBtnEkleAction}"></hx:commandExButton></td></tr>
						</tbody>
					</table>
				</h:form>
			</center>
		</hx:scriptCollector>
	</body>
</f:view>
</html>