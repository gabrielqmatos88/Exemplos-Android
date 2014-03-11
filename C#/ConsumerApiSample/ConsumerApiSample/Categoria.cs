using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsumerApiSample
{
	public class Categoria
	{
		public int Id { get; set; }

		public string Url_Img { get; set; }

		public string Descricao { get; set; }

		public Idioma Idioma { get; set; }
	}
}
