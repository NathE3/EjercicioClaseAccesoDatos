<?xml version="1.0" encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match='/'>
   <html><xsl:apply-templates /></html>
 </xsl:template>
 <xsl:template match='listadealumnos'>
    <head><title>LISTADO DE ALUMNOS</title></head>
    <body> 
    <h1>LISTA DE ALUMNOS</h1>
    <table border='1'>
    <tr><th>DNI</th><th>Nombre</th><th>Apellido</th><th>Dirección</th><th>CP</th><th>Provincia</th><th>Telefono</th><th>e-mail</th><th>edad</th></tr>
      <xsl:apply-templates select='alumno' />
    </table>
    </body>
 </xsl:template>
 <xsl:template match='alumno'>
   <tr><xsl:apply-templates /></tr>
 </xsl:template>
 <xsl:template match='DNI|nombre|apellido|direccion|cp|provincia|telefono|e-mail|edad'>
   <td><xsl:apply-templates /></td>
 </xsl:template>
</xsl:stylesheet>