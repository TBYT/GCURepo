using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BibleVerseApp.Models;
using BibleVerseApp.Services.Utilities;
using System.Data.SqlClient;

namespace BibleVerseApp.Services.DataAccess
{
    public class BibleData : DatabaseManager
    {
        // IENumerable in C# is an interface that defines one method,
        // This allows readonly access to a collection then a collection that implements IEnumerable can be used with a foreach loop.
        public IEnumerable<BibleVerse> getBibleVerses(VerseSearch searchCriteria)
        {
            string testamentSearch = "";
            //Create the transport LIST
            List<BibleVerse> searchResults = new List<BibleVerse>();
            using(SqlConnection connection = new SqlConnection(connString))
            {
                connection.Open();
                //Write the code to test for the testament
                if (searchCriteria.Testament == "OT")
                {
                    testamentSearch = " AND key_english.t = 'OT'";
                }
                else if (searchCriteria.Testament == "NT")
                {
                    testamentSearch = " AND key_english.t = 'NT'";
                }
                else testamentSearch = "";

                //Define the query
                string query = string.Format(@"SELECT bible.t AS Text, bible.b, bible.c AS Chapter, bible.v AS Verse,
                key_english.n AS Book, key_english.t AS Testament, key_english.g, key_genre_english.g, key_genre_english.n AS Genre
                FROM {0} bible
                JOIN key_english
                ON bible.b = key_english.b
                JOIN key_genre_english
                ON key_english.g = key_genre_english.g
                WHERE bible.t LIKE '%{1}%' {2}
                ORDER BY bible.b, Chapter, Verse", searchCriteria.BibleVersion, searchCriteria.Text, testamentSearch);

                using(SqlCommand command = new SqlCommand(query,connection))
                {
                    using(SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            //Instantiate our BibleVerse Class creating an object called verse
                            BibleVerse verse = new BibleVerse();
                            //Populate this object with a verse that was found
                            verse.BookName = reader["Book"].ToString();
                            verse.Chapter = Convert.ToInt32(reader["Chapter"].ToString());
                            verse.Verse = Convert.ToInt32(reader["Verse"].ToString());
                            verse.Genre = reader["Genre"].ToString();
                            verse.Text = reader["Text"].ToString();
                            if (reader["Testament"].ToString() == "OT")
                            {
                                verse.OT_NT = "Old Testament";
                            }
                            else verse.OT_NT = "New Testament";

                            searchResults.Add(verse);
                        }
                    }
                }
            }

            return searchResults;
        }
    }
}
