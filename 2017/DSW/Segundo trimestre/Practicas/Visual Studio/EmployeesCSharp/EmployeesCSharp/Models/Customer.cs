using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EmployeesCSharp.Models
{
    public class Customer
    {
        public Customer(string customerName, string address)
        {
            CustomerName = customerName;
            Address = address;
        }

        public string CustomerName { get; set; }
        public string Address { get; set; }


        public override string ToString()
        {
            return this.CustomerName + " - " + this.Address;
        }
    }

}