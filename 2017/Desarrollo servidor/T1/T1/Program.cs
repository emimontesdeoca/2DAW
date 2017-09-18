using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T1
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> l = new List<int>() { 1, 2, 3 };
            int r = 0;
            foreach (int i in l)
            {
                r = r + i;
            }
            Console.WriteLine("Hola el doble del resultado es: {0}", r);
            Console.ReadLine();
        }
    }
}
