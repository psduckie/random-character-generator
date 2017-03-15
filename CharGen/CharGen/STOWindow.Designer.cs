namespace CharGen
{
    partial class STOWindow
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnGenerate = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.lblClass = new System.Windows.Forms.Label();
            this.lblShip = new System.Windows.Forms.Label();
            this.lblFaction = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.cboTypeOfPick = new System.Windows.Forms.ComboBox();
            this.cboAlignmentPick = new System.Windows.Forms.ComboBox();
            this.cboFactionPick = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            this.lblAlignmentPick = new System.Windows.Forms.Label();
            this.lblFactionPick = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.lblRace = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnGenerate
            // 
            this.btnGenerate.Location = new System.Drawing.Point(208, 216);
            this.btnGenerate.Name = "btnGenerate";
            this.btnGenerate.Size = new System.Drawing.Size(75, 23);
            this.btnGenerate.TabIndex = 10;
            this.btnGenerate.Text = "Generate!";
            this.btnGenerate.UseVisualStyleBackColor = true;
            this.btnGenerate.Click += new System.EventHandler(this.btnGenerate_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(49, 172);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(61, 25);
            this.label3.TabIndex = 4;
            this.label3.Text = "Ship:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(49, 147);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(72, 25);
            this.label2.TabIndex = 5;
            this.label2.Text = "Class:";
            // 
            // lblClass
            // 
            this.lblClass.AutoSize = true;
            this.lblClass.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblClass.Location = new System.Drawing.Point(144, 147);
            this.lblClass.Name = "lblClass";
            this.lblClass.Size = new System.Drawing.Size(0, 25);
            this.lblClass.TabIndex = 6;
            // 
            // lblShip
            // 
            this.lblShip.AutoSize = true;
            this.lblShip.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblShip.Location = new System.Drawing.Point(144, 172);
            this.lblShip.Name = "lblShip";
            this.lblShip.Size = new System.Drawing.Size(0, 25);
            this.lblShip.TabIndex = 7;
            // 
            // lblFaction
            // 
            this.lblFaction.AutoSize = true;
            this.lblFaction.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblFaction.Location = new System.Drawing.Point(144, 95);
            this.lblFaction.Name = "lblFaction";
            this.lblFaction.Size = new System.Drawing.Size(0, 25);
            this.lblFaction.TabIndex = 8;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(49, 95);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(89, 25);
            this.label1.TabIndex = 9;
            this.label1.Text = "Faction:";
            // 
            // cboTypeOfPick
            // 
            this.cboTypeOfPick.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboTypeOfPick.FormattingEnabled = true;
            this.cboTypeOfPick.Items.AddRange(new object[] {
            "Random",
            "Specific Alignment",
            "Specific Faction"});
            this.cboTypeOfPick.Location = new System.Drawing.Point(54, 33);
            this.cboTypeOfPick.Name = "cboTypeOfPick";
            this.cboTypeOfPick.Size = new System.Drawing.Size(121, 21);
            this.cboTypeOfPick.TabIndex = 11;
            this.cboTypeOfPick.SelectedIndexChanged += new System.EventHandler(this.cboTypeOfPick_SelectedIndexChanged);
            // 
            // cboAlignmentPick
            // 
            this.cboAlignmentPick.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboAlignmentPick.FormattingEnabled = true;
            this.cboAlignmentPick.Items.AddRange(new object[] {
            "Federation",
            "Klingon"});
            this.cboAlignmentPick.Location = new System.Drawing.Point(208, 33);
            this.cboAlignmentPick.Name = "cboAlignmentPick";
            this.cboAlignmentPick.Size = new System.Drawing.Size(209, 21);
            this.cboAlignmentPick.TabIndex = 12;
            this.cboAlignmentPick.Visible = false;
            // 
            // cboFactionPick
            // 
            this.cboFactionPick.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cboFactionPick.FormattingEnabled = true;
            this.cboFactionPick.Items.AddRange(new object[] {
            "Federation",
            "Klingon",
            "Romulan (Federation aligned)",
            "Romulan (Klingon aligned)",
            "TOS Federation"});
            this.cboFactionPick.Location = new System.Drawing.Point(208, 33);
            this.cboFactionPick.Name = "cboFactionPick";
            this.cboFactionPick.Size = new System.Drawing.Size(209, 21);
            this.cboFactionPick.TabIndex = 13;
            this.cboFactionPick.Visible = false;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(54, 13);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(42, 13);
            this.label4.TabIndex = 14;
            this.label4.Text = "Faction";
            // 
            // lblAlignmentPick
            // 
            this.lblAlignmentPick.AutoSize = true;
            this.lblAlignmentPick.Location = new System.Drawing.Point(208, 13);
            this.lblAlignmentPick.Name = "lblAlignmentPick";
            this.lblAlignmentPick.Size = new System.Drawing.Size(53, 13);
            this.lblAlignmentPick.TabIndex = 15;
            this.lblAlignmentPick.Text = "Alignment";
            this.lblAlignmentPick.Visible = false;
            // 
            // lblFactionPick
            // 
            this.lblFactionPick.AutoSize = true;
            this.lblFactionPick.Location = new System.Drawing.Point(208, 13);
            this.lblFactionPick.Name = "lblFactionPick";
            this.lblFactionPick.Size = new System.Drawing.Size(42, 13);
            this.lblFactionPick.TabIndex = 16;
            this.lblFactionPick.Text = "Faction";
            this.lblFactionPick.Visible = false;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(49, 120);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(68, 25);
            this.label5.TabIndex = 17;
            this.label5.Text = "Race:";
            // 
            // lblRace
            // 
            this.lblRace.AutoSize = true;
            this.lblRace.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblRace.Location = new System.Drawing.Point(143, 120);
            this.lblRace.Name = "lblRace";
            this.lblRace.Size = new System.Drawing.Size(0, 25);
            this.lblRace.TabIndex = 18;
            // 
            // STOWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(481, 288);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.lblRace);
            this.Controls.Add(this.lblFactionPick);
            this.Controls.Add(this.lblAlignmentPick);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.cboFactionPick);
            this.Controls.Add(this.cboAlignmentPick);
            this.Controls.Add(this.cboTypeOfPick);
            this.Controls.Add(this.btnGenerate);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.lblClass);
            this.Controls.Add(this.lblShip);
            this.Controls.Add(this.lblFaction);
            this.Controls.Add(this.label1);
            this.Name = "STOWindow";
            this.Text = "Star Trek Online Character Generator";
            this.Load += new System.EventHandler(this.STOWindow_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnGenerate;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label lblClass;
        private System.Windows.Forms.Label lblShip;
        private System.Windows.Forms.Label lblFaction;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cboTypeOfPick;
        private System.Windows.Forms.ComboBox cboAlignmentPick;
        private System.Windows.Forms.ComboBox cboFactionPick;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label lblAlignmentPick;
        private System.Windows.Forms.Label lblFactionPick;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label lblRace;
    }
}