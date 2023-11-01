package Junit.SQL;

public class Script {
    public String GeraScript(String codigo, String tipo, boolean notNull, boolean autoIncrement, String dbms) {
        StringBuilder script = new StringBuilder();
        script.append("`").append(codigo).append("` ").append(tipo);

        if (notNull) {
            script.append(" NOT NULL");
        }

        if (autoIncrement) {
            switch(dbms.toLowerCase()) {
                case "mysql":
                    script.append(" AUTO_INCREMENT");
                    break;
                case "sqlserver":
                    script.append(" IDENTITY(1,1)");
                    break;
                case "postgresql":
                    script.append(" SERIAL");
                    break;
                default:
                    throw new IllegalArgumentException("DBMS desconhecido: " + dbms);
            }
        }

        return script.toString();
    }
}

