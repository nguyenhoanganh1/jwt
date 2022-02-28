<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/20/2021
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport"content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="/static/css/style.css" />
    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/jquery/jquery.min.js"></script>
   <%-- <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js" integrity="sha512-iKDtgDyTHjAitUDdLljGhenhPwrbBfqTKWO1mkhSFH3A7blITC9MhYon6SjnMhp4o0rADGw9yAC6EW4t5a4K3g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js" referrerpolicy="no-referrer"></script>
    <script src="/static/js/chat.js"></script>
    <title>Title</title>
</head>
<body>
<div id="welcome-page">
    <div class="welcome-page-container">
        <h1 class="title">Welcome - To join the chat group enter your
            name</h1>
        <form id="welcomeForm" name="welcomeForm">
            <div class="form-group">
                <input type="text" id="name" placeholder="name"
                       class="form-control" />
            </div>
            <div class="form-group">
                <button type="submit" onclass="accent username-submit">Lets
                    Begin</button>
            </div>
        </form>
    </div>
</div>


<div id="dialogue-page" class="hidden">
    <div class="dialogue-container">
        <div class="dialogue-header">
            <h2>JavaInUse Chat Application</h2>
        </div>
        <ul id="messageList">

        </ul>
        <form id="dialogueForm" name="dialogueForm" nameForm="dialogueForm">
            <div class="form-group">
                <div class="input-group clearfix">
                    <input type="text" id="chatMessage"
                           placeholder="Enter a message...." autocomplete="off"
                           class="form-control" />
                    <button type="submit" class="glyphicon glyphicon-share-alt">Send</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
