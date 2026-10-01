using ConsoleApp1.Modelos;
using ConsoleApp1.Servicios;

Console.WriteLine("========================================");
Console.WriteLine("   SIMULADOR DE CONEXIONES A BASE DATOS ");
Console.WriteLine("========================================\n");

// INSTANCIACIÓN
ConexionSqlServer bdSql = new ConexionSqlServer("Server=myServerAddress;Database=myDataBase;");
ConexionPostgreSql bdPostgre = new ConexionPostgreSql("Host=myServer;Database=myDataBase;");

// ENCAPSULAMIENTO
// Intento fallido de consulta con la conexión cerrada
bdSql.EjecutarConsulta("SELECT * FROM Usuarios");

// POLIMORFISMO 
GestorBaseDatos gestor = new GestorBaseDatos();

// Enviamos SQL Server al gestor
gestor.ProcesarTransaccion(bdSql, "SELECT * FROM Clientes");

// Enviamos PostgreSQL al mismo gestor
gestor.ProcesarTransaccion(bdPostgre, "INSERT INTO Logs VALUES ('Login OK')");

Console.WriteLine("\nPresiona cualquier tecla para cerrar la simulación...");
Console.ReadKey();