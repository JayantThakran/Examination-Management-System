import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExamResult extends HttpServlet  {

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                String n=request.getParameter("formno");
                
                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","bishwa");
                PreparedStatement ps=con.prepareStatement("select sgpa,name,semester,course,enroll from student_details where formno=?;");
                ps.setString(1,n);

                ResultSet rs=ps.executeQuery();


                if (rs.next() == false) {
                	out.print("\r\n"
                			+ "<!DOCTYPE html>\r\n"
                			+ "<html>\r\n"
                			+ "    <head>\r\n"
                			+ "        <title>EXAMINATION | RESULT</title>   \r\n"
                			+ "       <style>\r\n"
                			+ "\r\n"
                			+ "\r\n"
                			+ "/*   HEADER STYLING COMMANDS     */\r\n"
                			+ "\r\n"
                			+ "\r\n"
                			+ "/*\r\n"
                			+ "      FORM STYLING     */   \r\n"
                			+ "\r\n"
                			+ ".form-bg{\r\n"
                			+ "  \r\n"
                			+ "    background-image:url(\"result.jpg\");  \r\n"
                			+ "    \r\n"
                			+ "}\r\n"
                			+ ".form-bg{\r\n"
                			+ "     height: 458px;\r\n"
                			+ "    background-color: #f1f2f6;\r\n"
                			+ "    padding: 15% 36% 5% 36%;\r\n"
                			+ "   font-size: 30px;\r\n"
                			+ "   background-size: 100% 100%;   \r\n"
                			+ "    margin:-15px -8px 0px -8px;\r\n"
                			+ "}\r\n"
                			+ ".form-txt-bg{\r\n"
                			+ "    \r\n"
                			+ "    background-color: #222831;\r\n"
                			+ "    border: 1px #ced6e0 solid;\r\n"
                			+ "    border-radius: 3px;\r\n"
                			+ "     background:rgba(0,0,0,0.7);     \r\n"
                			+ "  }\r\n"
                			+ "  .form-header{\r\n"
                			+ "      \r\n"
                			+ "      font-size:0.75em;\r\n"
                			+ "      padding: 35px 0px 15px 30px;   \r\n"
                			+ "      color: white;\r\n"
                			+ "      font-weight: bolder;\r\n"
                			+ "      text-align:left;\r\n"
                			+ "  }  \r\n"
                			+ "  .inputs{      \r\n"
                			+ "      background: #433d3c;\r\n"
                			+ "      font-size: 0.5em;\r\n"
                			+ "      width:80%;\r\n"
                			+ "      padding: 0.6em;\r\n"
                			+ "      margin:0 1em;\r\n"
                			+ "      border: 2px #ced6e0 solid;\r\n"
                			+ "      border-radius: 4px;\r\n"
                			+ "      color:#f6ecf0;\r\n"
                			+ "      margin-bottom: 10px;\r\n"
                			+ "    }\r\n"
                			+ "    .inputs:focus{\r\n"
                			+ "        background:#5aa469;\r\n"
                			+ "        outline: none;\r\n"
                			+ "    }\r\n"
                			+ "    .form-btn{\r\n"
                			+ "        width: 85%;\r\n"
                			+ "        margin: 1.4em 0.7em 1.4em ;\r\n"
                			+ "        padding:0.7em;\r\n"
                			+ "        font-size: 0.5em;\r\n"
                			+ "        background-color: #e40017;\r\n"
                			+ "        border:none;\r\n"
                			+ "        border-radius:4px;\r\n"
                			+ "        color: white;\r\n"
                			+ "        font-weight: bolder;\r\n"
                			+ "    }\r\n"
                			+ "    .form-btn:focus{\r\n"
                			+ "        background: none;\r\n"
                			+ "        outline: none;\r\n"
                			+ "    }\r\n"
                			+ "    .form-btn:active{\r\n"
                			+ "        background-color:green;\r\n"
                			+ "        border-color: green;\r\n"
                			+ "    }\r\n"
                			+ "    .forgot a{\r\n"
                			+ "          text-decoration: none;  \r\n"
                			+ "          color:silver;\r\n"
                			+ "      }\r\n"
                			+ "    .forgot{        \r\n"
                			+ "        font-size: 0.5em;   \r\n"
                			+ "        padding-right: 30px;\r\n"
                			+ "        text-align:right;        \r\n"
                			+ "      }        \r\n"
                			+ "      .forgot a:hover{\r\n"
                			+ "          color: blue;\r\n"
                			+ "      }\r\n"
                			+ "      .forgot a:active{\r\n"
                			+ "          color: green;\r\n"
                			+ "      }\r\n"
                			+ "      .input-title{\r\n"
                			+ "      float: left;\r\n"
                			+ "      font-size: 0.5em;\r\n"
                			+ "      font-weight: bolder;\r\n"
                			+ "      margin: 1.4em 0 0 1.4em;\r\n"
                			+ "      padding-left: 15px;      \r\n"
                			+ "      color: silver;\r\n"
                			+ "  }\r\n"
                			+ "  \r\n"
                			+ "      .incorrect{\r\n"
                			+ "        color:rgb(247, 71, 71) !important ;\r\n"
                			+ "        text-align :left !important;\r\n"
                			+ "        padding-left: 30px !important;\r\n"
                			+ "        /* padding-top: 350px; */\r\n"
                			+ "        font-size: 0.5em;  \r\n"
                			+ "    }\r\n"
                			+ "\r\n"
                			+ "       </style>\r\n"
                			+ "    </head>\r\n"
                			+ "    <body>                        \r\n"
                			+ "           <div class=\"form-bg\">          \r\n"
                			+ "            <center class=\"form-txt-bg\">\r\n"
                			+ "                <form method=\"post\" action=\"ExamResult\">\r\n"
                			+ "                <div class=\"form-header\">STUDENT RESULT</div>\r\n"
                			+ "                <div class=\"form-content\">               \r\n"
                			+ "                     <div class=\"input-title\">Form Number</div> \r\n"
                			+ "                    <input type=\"text\" id=\"form\" class=\"inputs\" placeholder=\"Form Number\" name=\"formno\"> \r\n"
                			+ "                    <div class=\"input-title\">Semester</div> \r\n"
                			+ "                    <input type=\"number\" id=\"semester\" class=\"inputs\" placeholder=\"Semester\" name=\"Semester\" >     \r\n"
                			+ "                   <p class = \"incorrect\" >*Please enter correct Details</p>                  \r\n"
                			+ "                    <button type=\"submit\" class=\"form-btn\">Result</button>\r\n"
                			+ "                </div>                \r\n"
                			+ "                </form>\r\n"
                			+ "        </center>\r\n"
                			+ "    </div>    \r\n"
                			+ "    </body>\r\n"
                			+ "</html>");
                }
                
                
                else {
                	float sgpa = rs.getFloat("sgpa");
                	String name = rs.getString("name");
                	String sem = rs.getString("semester");
                	String c = rs.getString("course");
                	String en = rs.getString("enroll");
                	
                	out.print("<!DOCTYPE html>\r\n"
                			+ "<html>\r\n"
                			+ "    <head>\r\n"
                			+ "        <title>Examination|RESULT</title>   \r\n"
                			+ "       <style>\r\n"
                			+ "\r\n"
                			+ "\r\n"
                			+ "/*   HEADER STYLING COMMANDS     */\r\n"
                			+ "\r\n"
                			+ "\r\n"
                			+ "/*\r\n"
                			+ "      FORM STYLING     */   \r\n"
                			+ "\r\n"
                			+ ".form-bg{\r\n"
                			+ "  \r\n"
                			+ "    background-image:url(\"result.jpg\");  \r\n"
                			+ "    \r\n"
                			+ "}\r\n"
                			+ ".form-bg{\r\n"
                			+ "     height: 458px;\r\n"
                			+ "    background-color: #f1f2f6;\r\n"
                			+ "    padding: 8% 36% 12% 36%;\r\n"
                			+ "   font-size: 30px;\r\n"
                			+ "   background-size: 100% 100%;   \r\n"
                			+ "    margin:-15px -8px 0px -8px;\r\n"
                			+ "}\r\n"
                			+ ".form-txt-bg{\r\n"
                			+ "    \r\n"
                			+ "    background-color: #222831;\r\n"
                			+ "    border: 1px #ced6e0 solid;\r\n"
                			+ "    border-radius: 3px;\r\n"
                			+ "     background:rgba(0,0,0,0.7);     \r\n"
                			+ "  }\r\n"
                			+ "  .form-header{\r\n"
                			+ "      \r\n"
                			+ "      font-size:0.75em;\r\n"
                			+ "      padding: 35px 0px 15px 30px;   \r\n"
                			+ "      color: white;\r\n"
                			+ "      font-weight: bolder;\r\n"
                			+ "      text-align:left;\r\n"
                			+ "  }  \r\n"
                			+ "  .inputs{      \r\n"
                			+ "      background: #433d3c;\r\n"
                			+ "      font-size: 0.5em;\r\n"
                			+ "      width:80%;\r\n"
                			+ "      padding: 0.6em;\r\n"
                			+ "      margin:0 1em;\r\n"
                			+ "      border: 2px #ced6e0 solid;\r\n"
                			+ "      border-radius: 4px;\r\n"
                			+ "      color:#f6ecf0;\r\n"
                			+ "      margin-bottom: 10px;\r\n"
                			+ "    }\r\n"
                			+ "    .inputs:focus{\r\n"
                			+ "        background:#5aa469;\r\n"
                			+ "        outline: none;\r\n"
                			+ "    }\r\n"
                			+ "    .form-btn{\r\n"
                			+ "        width: 85%;\r\n"
                			+ "        margin: 1.4em 0.7em 1.4em ;\r\n"
                			+ "        padding:0.7em;\r\n"
                			+ "        font-size: 0.5em;\r\n"
                			+ "        background-color: #e40017;\r\n"
                			+ "        border:none;\r\n"
                			+ "        border-radius:4px;\r\n"
                			+ "        color: white;\r\n"
                			+ "        font-weight: bolder;\r\n"
                			+ "    }\r\n"
                			+ "    .form-btn:focus{\r\n"
                			+ "        background: none;\r\n"
                			+ "        outline: none;\r\n"
                			+ "    }\r\n"
                			+ "    .form-btn:active{\r\n"
                			+ "        background-color:green;\r\n"
                			+ "        border-color: green;\r\n"
                			+ "    }\r\n"
                			+ "    .forgot a{\r\n"
                			+ "          text-decoration: none;  \r\n"
                			+ "          color:silver;\r\n"
                			+ "      }\r\n"
                			+ "    .forgot{        \r\n"
                			+ "        font-size: 0.5em;   \r\n"
                			+ "        padding-right: 30px;\r\n"
                			+ "        text-align:right;        \r\n"
                			+ "      }        \r\n"
                			+ "      .forgot a:hover{\r\n"
                			+ "          color: blue;\r\n"
                			+ "      }\r\n"
                			+ "      .forgot a:active{\r\n"
                			+ "          color: green;\r\n"
                			+ "      }\r\n"
                			+ "      .input-title{\r\n"
                			+ "      float: left;\r\n"
                			+ "      font-size: 0.5em;\r\n"
                			+ "      font-weight: bolder;\r\n"
                			+ "      margin: 0.4em 0 0 1.4em;\r\n"
                			+ "      padding-left: 15px;      \r\n"
                			+ "      color: silver;\r\n"
                			+ "  }\r\n"
                			+ "  .sg{\r\n"
                			+ "      margin: 1em 0 0 1.1em;\r\n"
                			+ "  }\r\n"
                			+ "  #grade{\r\n"
                			+ "      margin-bottom: 2em;\r\n"
                			+ "  }\r\n"
                			+ "\r\n"
                			+ "       </style>\r\n"
                			+ "    </head>\r\n"
                			+ "    <body>                        \r\n"
                			+ "           <div class=\"form-bg\">          \r\n"
                			+ "            <center class=\"form-txt-bg\">\r\n"
                			+ "                <form method=\"post\" action=\"database\">\r\n"
                			+ "                <div class=\"form-header\">EXAM RESULT</div>\r\n"
                			+ "                <div class=\"form-content\">               \r\n"
                			+ "                     <div class=\"input-title\">Form Number</div> \r\n"
                			+ "                     <input type=\"text\" id=\"form\" class=\"inputs\" value="+ n +" disabled> \r\n"
                			+ "                    <div class=\"input-title\">Name</div> \r\n"
                			+ "                    <input type=\"text\" id=\"name\" class=\"inputs\" value="+ name +" disabled> \r\n"
                			+ "                    <div class=\"input-title\">Enrollment Number</div> \r\n"
                			+ "                    <input type=\"text\" id=\"enroll\" class=\"inputs\" value="+  en +"  disabled> \r\n"
                			+ "                    <div class=\"input-title\">Course</div> \r\n"
                			+ "                    <input type=\"text\" id=\"course\" class=\"inputs\" value="+ c +"  disabled> \r\n"
                			+ "                    <div class=\"input-title\">Semester</div> \r\n"
                			+ "                    <input type=\"text\" id=\"semester\" class=\"inputs\" value="+ sem +" disabled >    \r\n"
                			+ "                    <div class=\"input-title sg\">Grade Point</div> \r\n"
                			+ "                    <input type=\"text\" id=\"grade\" class=\"inputs\" value="+ sgpa +"  disabled>                     \r\n"
                			+ "                </div>                \r\n"
                			+ "                </form>\r\n"
                			+ "        </center>\r\n"
                			+ "    </div>    \r\n"
                			+ "    </body>\r\n"
                			+ "</html>");
                }
                
                }catch (Exception e2) {System.out.println(e2);}

                out.close();
            }
}