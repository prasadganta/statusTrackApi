<<<<<<< HEAD
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="javascript">
    var xmlhttp;
    function init() {
       // put more code here in case you are concerned about browsers that do not provide XMLHttpRequest object directly
       xmlhttp = new XMLHttpRequest();
    }
    function getdetails() {
        var username = document.getElementById("username");
        var pwd = document.getElementById("pwd");
        var url = "http://localhost:7070/api/loginRequest?" + "username="+username.value+"&&"+"pwd="+pwd.value;
        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {

              
               if (xmlhttp.readyState == 4) {
                  if ( xmlhttp.status == 200) {
                	  alert(xmlhttp.responseText);
                       var res = eval( "(" +  xmlhttp.responseText + ")");
                       alert(res.success);
                       document.getElementById("res").value=res.success;
                 }
                 else
                       alert("Error ->" + xmlhttp.responseText);
              }
        };
    }
  </script>
  </head>
  <body  onload="init()">
   <h1>Status Tracker Authentication</h1>
   <table>
   <tr>
       <td>Enter username :  </td>
       <td><input type="text" id="username" size="10"/> 
   </tr>
      <tr>
       <td>password : </td>
       <td><input type="password"  id="pwd" size="10"/> </td>
   </tr>
         <tr>
       <td><input type="button" value="Get Details" onclick="getdetails()"/></td>
       <td><input type="text" value="response" id="res""/></td>
   </tr>
   
   </table>
  </body>
=======
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="javascript">
    var xmlhttp;
    function init() {
       // put more code here in case you are concerned about browsers that do not provide XMLHttpRequest object directly
       xmlhttp = new XMLHttpRequest();
    }
    function getdetails() {
        var username = document.getElementById("username");
        var pwd = document.getElementById("pwd");
        var url = "http://localhost:7070/api/loginRequest?" + "username="+username.value+"&&"+"pwd="+pwd.value;
        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {

              
               if (xmlhttp.readyState == 4) {
                  if ( xmlhttp.status == 200) {
                	  alert(xmlhttp.responseText);
                       var res = eval( "(" +  xmlhttp.responseText + ")");
                       alert(res.success);
                       document.getElementById("res").value=res.success;
                 }
                 else
                       alert("Error ->" + xmlhttp.responseText);
              }
        };
    }
  </script>
  </head>
  <body  onload="init()">
   <h1>Status Tracker Authentication</h1>
   <table>
   <tr>
       <td>Enter username :  </td>
       <td><input type="text" id="username" size="10"/> 
   </tr>
      <tr>
       <td>password : </td>
       <td><input type="password"  id="pwd" size="10"/> </td>
   </tr>
         <tr>
       <td><input type="button" value="Get Details" onclick="getdetails()"/></td>
       <td><input type="text" value="response" id="res""/></td>
   </tr>
   
   </table>
  </body>
>>>>>>> 44663fccec70c11d3baafbaea42169259ac2ea2d
</html>