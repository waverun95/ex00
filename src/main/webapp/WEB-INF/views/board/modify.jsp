<%--
  Created by IntelliJ IDEA.
  User: joonyoung
  Date: 2023-02-06
  Time: 오전 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">수정하기</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">
        register
      </div>
      <!-- /.panel-heading -->
      <div class="panel-body">

        <form action="/board/modify" method="post">
          <input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum}'/>">
          <input type="hidden" name="amount" value="<c:out value='${cri.amount}'/>">
          <input type="hidden" name="type" value="<c:out value='${cri.type}'/>">
          <input type="hidden" name="keyword" value="<c:out value='${cri.keyword}'/>">

          <div class="form-group">
            <label>Bno</label> <input class="form-control" name="bno" readonly="readonly" value="<c:out value='${board.bno}'/>">
          </div>
          <div class="form-group">
            <label>Title</label> <input class="form-control" name="title" value="<c:out value='${board.title}'/>">
          </div>
          <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" rows="3" name="content" ><c:out value="${board.content}"/></textarea>
          </div>
          <div class="form-group">
            <label>Writer</label> <input class="form-control" name="writer" value='<c:out value="${board.writer}"/>'>
          </div>
          <div class="form-group">
            <label>RegDate</label>
            <input class="form-control" name="regdate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}"/>' readonly="readonly">
          </div>
          <div class="form-group">
            <label>UpdateDate</label>
            <input class="form-control" name="updateDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}"/>' readonly="readonly">
          </div>
          <button type="submit"  data-oper="modify" class="btn btn-default">수정</button>
          <button type="submit" data-oper="remove" class="btn btn-default">삭제</button>
          <button type="submit" data-oper="list" class="btn btn-default">목록</button>
        </form>

      </div>
      <!--  end panel-body -->
    </div>
    <!-- end panel -->
  </div>
</div>
<!-- /.row -->
<script type="text/javascript">

  $(document).ready(function (){
    var formObj = $("form");

    $('button').on('click',function (e){
      e.preventDefault();
      console.log(this);
      var operation = $(this).data("oper");
      console.log(operation);

      if (operation === 'remove'){
        formObj.attr("action","/board/remove");
      }else if (operation === 'list') {
       formObj.attr("action","/board/list").attr("method","get");
       var pageNumTag = $("input[name='pageNum']").clone();
       var amountTag = $("input[name='amount']").clone();
       var keywordTag = $("input[name='keyword']").clone();
       var typeTag = $("input[name='type']").clone();
       formObj.empty();
       formObj.append(pageNumTag);
       formObj.append(amountTag);
       formObj.append(keywordTag);
       formObj.append(typeTag);
      }
      formObj.submit();
    })
  })
</script>
<%@include file="../includes/footer.jsp"%>
