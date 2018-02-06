using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EmployeesCSharp.Models
{
    public class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Category { get; set; }

        public Product()
        {
        }

        public Product(int id, string name, string category)
        {
            Id = id;
            Name = name;
            Category = category;
        }

        public override string ToString()
        {
            return this.Id + " - " + this.Name + " - " + this.Category;
        }
    }
}