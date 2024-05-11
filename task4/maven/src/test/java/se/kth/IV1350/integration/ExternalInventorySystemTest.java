// package se.kth.IV1350.integration;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// public class ExternalInventorySystemTest {
//     private ExternalInventorySystem externalInventorySystemInstance;
//     @BeforeEach
//     void setUp(){
//         externalInventorySystemInstance = new ExternalInventorySystem();
//     }

//     @Test
//     void getItemFromDB_Success(){
//         int itemID = 1;
//         assertNotNull(externalInventorySystemInstance.getItemFromDB(itemID));
//     }

//     @Test
//     void getItemFromDB_Fail(){
//         int itemID = 10;
//         assertNull(externalInventorySystemInstance.getItemFromDB(itemID));
//     }
// }
