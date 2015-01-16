<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp" %>

<a href="/konfig/form.html" class="btn btn-success">Tambah</a> 
<br/>
<br/>
<table class="table table-bordered table-hover table-striped"> 
  <tr>
    <th>Kode</th>
    <th>Nama</th>
    <th>Nilai</th>
  </tr>
  <c:forEach items="${konfigurasis}" var="k">
  <tr>
    <td>${k.kode }</td>
    <td>${k.nama }</td>
    <td>${k.nilai }</td>
  </tr>
  </c:forEach>
</table>

