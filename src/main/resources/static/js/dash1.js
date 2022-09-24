google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        $.ajax({
          url: "api/equifax/diasVenciadas",
          dataType: "json",
        }).done(function (jsonData) {
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'nombre');
          data.addColumn('number', 'diasTotalVencidas');
          
  
          jsonData.forEach(function (row) {
            data.addRow([
              row.nombre,
              row.diasTotalVencidas
            ]);
          });
  
          var options = {
            title: 'Dias vencidos'
          };
  
  
          var chart = new google.visualization.PieChart(document.getElementById('piechart'));
          chart.draw(data, options );
        }).fail(function (jq, text, err) {
          console.log(text + ' - ' + err);
        });
  }