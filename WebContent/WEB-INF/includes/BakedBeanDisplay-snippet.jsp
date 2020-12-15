<%--

<H1>Repeated Baked Bean Values: request-based Sharing</H1>
<jsp:useBean id="requestBean" class="coreservlets.BakedBean"
             scope="request" />
<H2>Bean level: 
<jsp:getProperty name="requestBean" property="level" /></H2>
<H2>Dish bean goes with:
<jsp:getProperty name="requestBean" property="goesWith" /></H2>

 --%>
 
 
 <%--
 <H1>Repeated Baked Bean Values: request-based Sharing</H1>
<jsp:useBean id="SessionBean" class="coreservlets.BakedBean"
             scope="Session" />
<H2>Bean level: 
<jsp:getProperty name="SessionBean" property="level" /></H2>
<H2>Dish bean goes with:
<jsp:getProperty name="SessionBean" property="goesWith" /></H2>
 
  --%>
 

<H1>Repeated Baked Bean Values: request-based Sharing</H1>
<jsp:useBean id="pageBean" class="jac.finalproject.model.BakedBean"
             scope="page" />
<H2>Bean level: 
<jsp:getProperty name="pageBean" property="level" /></H2>
<H2>Dish bean goes with:
<jsp:getProperty name="pageBean" property="goesWith" /></H2>


