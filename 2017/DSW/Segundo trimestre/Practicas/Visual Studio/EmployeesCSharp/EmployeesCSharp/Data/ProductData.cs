using EmployeesCSharp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EmployeesCSharp.Data
{
    public class ProductData
    {
        public List<Product> GetData()
        {

            List<Product> lista = new List<Product>();
            for (int i = 0; i < 10; i++)
            {
                Product p = new Product(i, "Producto " + i, "Categoria " + i);
                lista.Add(p);
            }

            return lista;
        }
    }
}