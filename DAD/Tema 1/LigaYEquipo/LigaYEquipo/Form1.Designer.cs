namespace LigaYEquipo
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            menuStrip1 = new MenuStrip();
            archivoToolStripMenuItem = new ToolStripMenuItem();
            limpiarTablaToolStripMenuItem = new ToolStripMenuItem();
            salirToolStripMenuItem = new ToolStripMenuItem();
            tabControl1 = new TabControl();
            tabPage1 = new TabPage();
            tabPage2 = new TabPage();
            botonAgregar = new Button();
            tablaEquipos = new DataGridView();
            comboEquipo = new ComboBox();
            comboLiga = new ComboBox();
            label2 = new Label();
            label1 = new Label();
            menuStrip1.SuspendLayout();
            tabControl1.SuspendLayout();
            tabPage1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)tablaEquipos).BeginInit();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.ImageScalingSize = new Size(20, 20);
            menuStrip1.Items.AddRange(new ToolStripItem[] { archivoToolStripMenuItem });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new Size(800, 28);
            menuStrip1.TabIndex = 6;
            menuStrip1.Text = "menuStrip1";
            // 
            // archivoToolStripMenuItem
            // 
            archivoToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { limpiarTablaToolStripMenuItem, salirToolStripMenuItem });
            archivoToolStripMenuItem.Name = "archivoToolStripMenuItem";
            archivoToolStripMenuItem.Size = new Size(73, 24);
            archivoToolStripMenuItem.Text = "Archivo";
            // 
            // limpiarTablaToolStripMenuItem
            // 
            limpiarTablaToolStripMenuItem.Name = "limpiarTablaToolStripMenuItem";
            limpiarTablaToolStripMenuItem.Size = new Size(224, 26);
            limpiarTablaToolStripMenuItem.Text = "Limpiar tabla";
            limpiarTablaToolStripMenuItem.Click += limpiarTablaToolStripMenuItem_Click;
            // 
            // salirToolStripMenuItem
            // 
            salirToolStripMenuItem.Name = "salirToolStripMenuItem";
            salirToolStripMenuItem.Size = new Size(224, 26);
            salirToolStripMenuItem.Text = "Salir";
            salirToolStripMenuItem.Click += salirToolStripMenuItem_Click;
            // 
            // tabControl1
            // 
            tabControl1.Controls.Add(tabPage1);
            tabControl1.Controls.Add(tabPage2);
            tabControl1.Location = new Point(81, 43);
            tabControl1.Name = "tabControl1";
            tabControl1.SelectedIndex = 0;
            tabControl1.Size = new Size(666, 358);
            tabControl1.TabIndex = 7;
            // 
            // tabPage1
            // 
            tabPage1.Controls.Add(botonAgregar);
            tabPage1.Controls.Add(tablaEquipos);
            tabPage1.Controls.Add(comboEquipo);
            tabPage1.Controls.Add(comboLiga);
            tabPage1.Controls.Add(label2);
            tabPage1.Controls.Add(label1);
            tabPage1.Location = new Point(4, 29);
            tabPage1.Name = "tabPage1";
            tabPage1.Padding = new Padding(3);
            tabPage1.Size = new Size(658, 325);
            tabPage1.TabIndex = 0;
            tabPage1.Text = "Gestión de Equipos";
            tabPage1.UseVisualStyleBackColor = true;
            tabPage1.Click += tabPage1_Click;
            // 
            // tabPage2
            // 
            tabPage2.Location = new Point(4, 29);
            tabPage2.Name = "tabPage2";
            tabPage2.Padding = new Padding(3);
            tabPage2.Size = new Size(658, 325);
            tabPage2.TabIndex = 1;
            tabPage2.Text = "Estadísticas y Resumen";
            tabPage2.UseVisualStyleBackColor = true;
            tabPage2.Click += tabPage2_Click;
            // 
            // botonAgregar
            // 
            botonAgregar.Location = new Point(455, 164);
            botonAgregar.Name = "botonAgregar";
            botonAgregar.Size = new Size(94, 29);
            botonAgregar.TabIndex = 11;
            botonAgregar.Text = "Agregar";
            botonAgregar.UseVisualStyleBackColor = true;
            // 
            // tablaEquipos
            // 
            tablaEquipos.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            tablaEquipos.Location = new Point(110, 125);
            tablaEquipos.Name = "tablaEquipos";
            tablaEquipos.RowHeadersWidth = 51;
            tablaEquipos.Size = new Size(277, 159);
            tablaEquipos.TabIndex = 10;
            // 
            // comboEquipo
            // 
            comboEquipo.FormattingEnabled = true;
            comboEquipo.Location = new Point(331, 78);
            comboEquipo.Name = "comboEquipo";
            comboEquipo.Size = new Size(151, 28);
            comboEquipo.TabIndex = 9;
            // 
            // comboLiga
            // 
            comboLiga.FormattingEnabled = true;
            comboLiga.Location = new Point(110, 78);
            comboLiga.Name = "comboLiga";
            comboLiga.Size = new Size(151, 28);
            comboLiga.TabIndex = 8;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(357, 41);
            label2.Name = "label2";
            label2.Size = new Size(56, 20);
            label2.TabIndex = 7;
            label2.Text = "Equipo";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(144, 41);
            label1.Name = "label1";
            label1.Size = new Size(37, 20);
            label1.TabIndex = 6;
            label1.Text = "Liga";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(tabControl1);
            Controls.Add(menuStrip1);
            MainMenuStrip = menuStrip1;
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            tabControl1.ResumeLayout(false);
            tabPage1.ResumeLayout(false);
            tabPage1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)tablaEquipos).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private MenuStrip menuStrip1;
        private ToolStripMenuItem archivoToolStripMenuItem;
        private ToolStripMenuItem limpiarTablaToolStripMenuItem;
        private ToolStripMenuItem salirToolStripMenuItem;
        private TabControl tabControl1;
        private TabPage tabPage1;
        private TabPage tabPage2;
        private Button botonAgregar;
        private DataGridView tablaEquipos;
        private ComboBox comboEquipo;
        private ComboBox comboLiga;
        private Label label2;
        private Label label1;
    }
}
