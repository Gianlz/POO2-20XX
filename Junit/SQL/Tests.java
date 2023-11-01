package Junit.SQL;


import junit.framework.TestCase ;

public class Tests extends TestCase{

    public void testeScriptCorreto() {
        Script g = new Script();
        String script = g.GeraScript("codigo", "INT", true, true, "mysql");
        assertEquals("`codigo` INT NOT NULL AUTO_INCREMENT", script);
    }

    public void testeScriptSemNotNull() {
        Script g = new Script();
        String script = g.GeraScript("codigo", "INT", false, true, "mysql");
        assertEquals("`codigo` INT AUTO_INCREMENT", script);
    }

    public void testeScriptSemAutoIncrement() {
        Script g = new Script();
        String script = g.GeraScript("codigo", "INT", true, false, "mysql");
        assertEquals("`codigo` INT NOT NULL", script);
    }

    public void testeScriptNomeTipoDiferente() {
        Script g = new Script();
        String script = g.GeraScript("nome", "VARCHAR(100)", true, true, "mysql");
        assertEquals("`nome` VARCHAR(100) NOT NULL AUTO_INCREMENT", script);
    }


}
