using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BibleVerseApp.Models
{
    public class VerseSearch
    {
        //define model properties
        public string Testament { get; set; }
        public string BibleVersion { get; set; }
        public string Text { get; set; }
    }
}
