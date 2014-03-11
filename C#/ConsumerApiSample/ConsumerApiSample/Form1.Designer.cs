namespace ConsumerApiSample
{
	partial class Form1
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose( bool disposing )
		{
			if(disposing && ( components != null ))
			{
				components.Dispose();
			}
			base.Dispose( disposing );
		}

		#region Windows Form Designer generated code

		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			this.pictureBox = new System.Windows.Forms.PictureBox();
			this.label1 = new System.Windows.Forms.Label();
			this.lbDescricao = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.lbI = new System.Windows.Forms.Label();
			this.label3 = new System.Windows.Forms.Label();
			this.lbUrlImg = new System.Windows.Forms.Label();
			this.btLoad = new System.Windows.Forms.Button();
			this.btListar = new System.Windows.Forms.Button();
			this.categoriaBindingSource = new System.Windows.Forms.BindingSource(this.components);
			this.categoriaDataGridView = new System.Windows.Forms.DataGridView();
			this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.dataGridViewTextBoxColumn3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
			this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
			((System.ComponentModel.ISupportInitialize)(this.pictureBox)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.categoriaBindingSource)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.categoriaDataGridView)).BeginInit();
			this.SuspendLayout();
			// 
			// pictureBox
			// 
			this.pictureBox.Location = new System.Drawing.Point(12, 12);
			this.pictureBox.Name = "pictureBox";
			this.pictureBox.Size = new System.Drawing.Size(102, 104);
			this.pictureBox.TabIndex = 0;
			this.pictureBox.TabStop = false;
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(132, 13);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(52, 13);
			this.label1.TabIndex = 1;
			this.label1.Text = "Categoria";
			// 
			// lbDescricao
			// 
			this.lbDescricao.AutoSize = true;
			this.lbDescricao.Location = new System.Drawing.Point(132, 36);
			this.lbDescricao.Name = "lbDescricao";
			this.lbDescricao.Size = new System.Drawing.Size(0, 13);
			this.lbDescricao.TabIndex = 2;
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(206, 13);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(19, 13);
			this.label2.TabIndex = 3;
			this.label2.Text = "Id:";
			// 
			// lbI
			// 
			this.lbI.AutoSize = true;
			this.lbI.Location = new System.Drawing.Point(262, 13);
			this.lbI.Name = "lbI";
			this.lbI.Size = new System.Drawing.Size(0, 13);
			this.lbI.TabIndex = 4;
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Location = new System.Drawing.Point(132, 62);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(63, 13);
			this.label3.TabIndex = 5;
			this.label3.Text = "Url Imagem:";
			// 
			// lbUrlImg
			// 
			this.lbUrlImg.AutoSize = true;
			this.lbUrlImg.Location = new System.Drawing.Point(132, 103);
			this.lbUrlImg.Name = "lbUrlImg";
			this.lbUrlImg.Size = new System.Drawing.Size(0, 13);
			this.lbUrlImg.TabIndex = 6;
			// 
			// btLoad
			// 
			this.btLoad.Anchor = System.Windows.Forms.AnchorStyles.Right;
			this.btLoad.Location = new System.Drawing.Point(451, 88);
			this.btLoad.Name = "btLoad";
			this.btLoad.Size = new System.Drawing.Size(138, 28);
			this.btLoad.TabIndex = 7;
			this.btLoad.Text = "Carregar Informacoes";
			this.btLoad.UseVisualStyleBackColor = true;
			this.btLoad.Click += new System.EventHandler(this.btLoad_Click);
			// 
			// btListar
			// 
			this.btListar.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
			this.btListar.Location = new System.Drawing.Point(451, 5);
			this.btListar.Name = "btListar";
			this.btListar.Size = new System.Drawing.Size(138, 28);
			this.btListar.TabIndex = 8;
			this.btListar.Text = "Listar Categorias";
			this.btListar.UseVisualStyleBackColor = true;
			this.btListar.Click += new System.EventHandler(this.btListar_Click);
			// 
			// categoriaBindingSource
			// 
			this.categoriaBindingSource.DataSource = typeof(ConsumerApiSample.Categoria);
			// 
			// categoriaDataGridView
			// 
			this.categoriaDataGridView.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.categoriaDataGridView.AutoGenerateColumns = false;
			this.categoriaDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.categoriaDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.dataGridViewTextBoxColumn3,
            this.dataGridViewTextBoxColumn4,
            this.dataGridViewTextBoxColumn2});
			this.categoriaDataGridView.DataSource = this.categoriaBindingSource;
			this.categoriaDataGridView.Location = new System.Drawing.Point(2, 122);
			this.categoriaDataGridView.Name = "categoriaDataGridView";
			this.categoriaDataGridView.Size = new System.Drawing.Size(587, 265);
			this.categoriaDataGridView.TabIndex = 10;
			// 
			// dataGridViewTextBoxColumn1
			// 
			this.dataGridViewTextBoxColumn1.DataPropertyName = "Id";
			this.dataGridViewTextBoxColumn1.HeaderText = "Id";
			this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
			// 
			// dataGridViewTextBoxColumn3
			// 
			this.dataGridViewTextBoxColumn3.DataPropertyName = "Descricao";
			this.dataGridViewTextBoxColumn3.HeaderText = "Descricao";
			this.dataGridViewTextBoxColumn3.Name = "dataGridViewTextBoxColumn3";
			// 
			// dataGridViewTextBoxColumn4
			// 
			this.dataGridViewTextBoxColumn4.DataPropertyName = "Idioma";
			this.dataGridViewTextBoxColumn4.HeaderText = "Idioma";
			this.dataGridViewTextBoxColumn4.Name = "dataGridViewTextBoxColumn4";
			// 
			// dataGridViewTextBoxColumn2
			// 
			this.dataGridViewTextBoxColumn2.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
			this.dataGridViewTextBoxColumn2.DataPropertyName = "Url_Img";
			this.dataGridViewTextBoxColumn2.HeaderText = "Url_Img";
			this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
			// 
			// Form1
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(591, 388);
			this.Controls.Add(this.categoriaDataGridView);
			this.Controls.Add(this.btListar);
			this.Controls.Add(this.btLoad);
			this.Controls.Add(this.lbUrlImg);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.lbI);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.lbDescricao);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.pictureBox);
			this.Name = "Form1";
			this.Text = "Form1";
			this.Load += new System.EventHandler(this.Form1_Load);
			((System.ComponentModel.ISupportInitialize)(this.pictureBox)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.categoriaBindingSource)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.categoriaDataGridView)).EndInit();
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.PictureBox pictureBox;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label lbDescricao;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label lbI;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Label lbUrlImg;
		private System.Windows.Forms.Button btLoad;
		private System.Windows.Forms.Button btListar;
		private System.Windows.Forms.BindingSource categoriaBindingSource;
		private System.Windows.Forms.DataGridView categoriaDataGridView;
		private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
		private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
		private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
		private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
	}
}

