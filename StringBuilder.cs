using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ConsoleApp2
{
    class Program
    {
        static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder();
            string testString = "a6b5c3";
            char[] test = testString.ToCharArray();
            char placeholder;
            for (int i = 0; i < test.Length; i++)
            {
                placeholder = test[i];
                if (Char.IsLetter(placeholder)){
                    continue;
                }
                if (Char.IsDigit(placeholder))
                {
                    double number = char.GetNumericValue(test[i]);
                    for (int j = 0; j < number; j++)
                    {
                        sb.Append(test[i - 1]);
                    }
                }
            }
            testString = sb.ToString();
            Console.WriteLine(testString);
            Console.ReadLine();


        }
    }
}
