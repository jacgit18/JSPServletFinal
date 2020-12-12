<%@ attribute name="length" required="false" %>
<% 
int len = 50;
try {
  len = Integer.parseInt(length);
} catch(NumberFormatException nfe) {}
%>
<%=  jac.finalproject.controller.Primes.nextPrime
      ( jac.finalproject.controller.Primes.random(len)) %>