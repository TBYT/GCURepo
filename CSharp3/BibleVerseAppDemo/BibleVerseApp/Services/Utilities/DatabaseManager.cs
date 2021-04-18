using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BibleVerseApp.Services.Utilities
{
    public class DatabaseManager
    {
        //define the attributes
        public string connString { get; set; }

        /// <summary>
        /// Constructor to set the connection string
        /// </summary>
        public DatabaseManager()
        {
            this.connString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=Bible;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False";
        }
    }
}
