<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%
Blob image = null;
Connection con = null;
byte[ ] imgData = null ;
Statement stmt = null;
ResultSet rs = null;
try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","");
stmt = con.createStatement();
rs = stmt.executeQuery("select image from fruitimg");
while (rs.next()) {
image = rs.getBlob(2);
imgData = image.getBytes(2,(int)image.length());


// display the image
response.setContentType("image/jpg");
OutputStream o = response.getOutputStream();

o.write(imgData);
o.flush();
o.close();
}} catch (Exception e) {
out.println("Unable To Display image");
out.println("Image Display Error=" + e.getMessage());
return;
} finally {
try {
rs.close();
stmt.close();
con.close();
} catch (SQLException e) {
e.printStackTrace();
}

}%>
