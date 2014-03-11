using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Newtonsoft.Json;
using RestSharp;

namespace ConsumerApiSample
{
	public partial class Form1 : Form
	{
		const string BASE_URL = "http://gqmclass.com/api/categorias/";
		RestClient client;
		List<Categoria> categorias;
		public Form1()
		{
			client = new RestClient( BASE_URL );
			InitializeComponent();
		}

		private void Form1_Load( object sender, EventArgs e )
		{

		}

		private void btListar_Click( object sender, EventArgs e )
		{
			RestRequest requisicao = new RestRequest();
			
			IRestResponse response = client.Get( requisicao );
			BeginInvoke( new Action( () =>
			{
				categorias = JsonConvert.DeserializeObject<List<Categoria>>( response.Content );
				categoriaBindingSource.DataSource = categorias;
			} ) );
		}

		private void btLoad_Click( object sender, EventArgs e )
		{
			if(categoriaDataGridView.CurrentRow == null)
				return;

			int posicao = categoriaDataGridView.CurrentRow.Index;
			int id = (int)categoriaDataGridView[0, posicao].Value;

			Categoria c = null;

			c = categorias.FirstOrDefault( o => o.Id == id );

			if(c == null)
				return;

			lbDescricao.Text = c.Descricao;
			lbI.Text = c.Id.ToString();
			lbUrlImg.Text = c.Url_Img;
			pictureBox.Load(c.Url_Img);
		}
	}
}
