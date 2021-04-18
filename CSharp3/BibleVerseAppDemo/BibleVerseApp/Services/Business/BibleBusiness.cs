using BibleVerseApp.Models;
using BibleVerseApp.Services.DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BibleVerseApp.Services.Business
{
    public class BibleBusiness
    {
        public IEnumerable<BibleVerse> getAllVerses(VerseSearch passSearchCriteria)
        {
            //First we need to instantiate the data access layer
            BibleData PassToDataLayer = new BibleData();
            IEnumerable<BibleVerse> allVerses = PassToDataLayer.getBibleVerses(passSearchCriteria);
            return allVerses;
        }
    }
}
