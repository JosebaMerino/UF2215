<h1>Documentacion</h1>

<p>Endpoint: <b>${pageContext.request.contextPath}/api/libro/</b></p>


<p> Esta tabla muestra ejemplos de diferentes peticiones al servicio. Se puede hacer la llamada haciendo click en el link correspondiente</p>

<table>
  <tr>
    <th>Method</th>
    <th>URL</th>
    <th>Resultado STATUS</th>
    <th>Resultado RESPONSE BODY</th>
    <th>Prueba</th>
  </tr>
  <tr>
    <td>GET</td>
    <td>${pageContext.request.contextPath}/api/libro</td>
    <td>200</td>
    <td>[{libro}] (5 libros)</td>
    <td><a target="_blank" href="${pageContext.request.contextPath}/api/libro">Link</a>
    </td>
  </tr>
  <tr>
    <td>GET</td>
    <td>${pageContext.request.contextPath}/api/libro?nombre=l</td>
    <td>200</td>
    <td>[{libro}] (2 libros)</td>
    <td>
    <a target="_blank" href="${pageContext.request.contextPath}/api/libro?nombre=l">Link</a>
    </td>
  </tr>
  <tr>
    <td>GET</td>
    <td>${pageContext.request.contextPath}/api/libro?nombre=casa</td>
    <td>204</td>
    <td>(vacio)</td>
    <td>
    <a target="_blank" href="${pageContext.request.contextPath}/api/libro?nombre=casa">Link</a>

    </td>
  </tr>
</table>
<style>
table {
  border-collapse: collapse;
  margin-top: 20px
}

table, th, td {
  border: 1px solid black;
  padding: 10px;
}

</style>
