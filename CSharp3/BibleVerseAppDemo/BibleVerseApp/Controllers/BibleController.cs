using BibleVerseApp.Models;
using BibleVerseApp.Services.Business;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BibleVerseApp.Controllers
{
    public class BibleController : Controller
    {
        public IActionResult Index()
        {
            List<BibleVerse> searchResults = new List<BibleVerse>();
            return View(searchResults);
        }

        [HttpPost]
        public IActionResult Index([Bind] VerseSearch objSearch)
        {
            //Remember we created a list in the Data Access Layer
            List<BibleVerse> searchResults = new List<BibleVerse>();
            //Make sure the data is valid
            if(ModelState.IsValid)
            {
                // First we need to insantiate the business layer
                BibleBusiness sendSearchCrit = new BibleBusiness();
                searchResults = sendSearchCrit.getAllVerses(objSearch).ToList();
                return View(searchResults);
            }
            return View(searchResults);
        }
    }
}
