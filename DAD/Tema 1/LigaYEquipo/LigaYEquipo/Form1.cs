using System.Data;

namespace LigaYEquipo
{
    public partial class Form1 : Form
    {
        //Inicio los componentes
        private DataTable dtLigas = new DataTable();
        private DataTable dtEquipos = new DataTable();
        private DataTable dtGrid = new DataTable();

        public Form1()
        {
            InitializeComponent();
            cargarDatos();
        }

        //Creo un método que va a cargar datos
        private void cargarDatos()
        {
            // Ligas
            dtLigas.Columns.Add("Id", typeof(int));
            dtLigas.Columns.Add("Nombre", typeof(string));
            dtLigas.Rows.Add(1, "Fútbol");
            dtLigas.Rows.Add(2, "Baloncesto");

            // Equipos (LigaId indica a qué liga pertenece)
            dtEquipos.Columns.Add("Id", typeof(int));
            dtEquipos.Columns.Add("Nombre", typeof(string));
            dtEquipos.Columns.Add("LigaId", typeof(int));
            dtEquipos.Rows.Add(101, "Real Madrid", 1);
            dtEquipos.Rows.Add(102, "FC Barcelona", 1);
            dtEquipos.Rows.Add(103, "Lakers", 2);
            dtEquipos.Rows.Add(104, "Bulls", 2);

            // DataTable en memoria para el grid
            dtGrid.Columns.Add("Liga", typeof(string));
            dtGrid.Columns.Add("Equipo", typeof(string));
            tablaEquipos.DataSource = dtGrid;

            // Enlazar el combo de ligas (Display/Value antes del DataSource)
            comboLiga.DisplayMember = "Nombre";
            comboLiga.ValueMember = "Id";
            comboLiga.DataSource = dtLigas;
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboLiga.SelectedValue is int ligaId)
            {
                DataView dv = new DataView(dtEquipos);
                dv.RowFilter = "LigaId = " + ligaId;

                comboEquipo.DisplayMember = "Nombre";
                comboEquipo.ValueMember = "Id";
                comboEquipo.DataSource = dv;
            }
        }

        private void comboEquipo2_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void tablaEquipos_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void botonAgregar_Click(object sender, EventArgs e)
        {
            if (comboLiga.SelectedItem is DataRowView liga &&
                comboEquipo.SelectedItem is DataRowView equipo)
            {
                dtGrid.Rows.Add(liga["Nombre"], equipo["Nombre"]);
            }
        }

        private void limpiarTablaToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void tabPage1_Click(object sender, EventArgs e)
        {

        }

        private void tabPage2_Click(object sender, EventArgs e)
        {

        }
    }
}
