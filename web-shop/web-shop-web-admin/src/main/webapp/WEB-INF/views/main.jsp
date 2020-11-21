<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>猫猫商城 | 用户管理</title>
    <!-- 封装了一个 header -->
    <jsp:include page="../includes/header.jsp" />
</head>


<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>

    <jsp:include page="../includes/menu.jsp"/>



    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                商城主页
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页 </a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <!-- Main Context -->
        <section class="content">

        </section>
    </div>
    <!-- /.content-wrapper -->

<jsp:include page="../includes/copyright.jsp"/>

</div>

<jsp:include page="../includes/footer.jsp" />

</body>

</html>
