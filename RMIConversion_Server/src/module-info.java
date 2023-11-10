// module-info.java dans RMIConversion_Server
module RMIConversion_Server {
    exports rmiService; // Ajoutez cette ligne pour exporter le package rmiService
    requires java.rmi;
}
