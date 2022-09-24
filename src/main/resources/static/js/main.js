const app = Vue.createApp({
  data() {
    return {
      exifax: {},
      dni: '',
      ocultar: false,

    }
  },
  methods: {
    async Apiequifax() {
      try {
        const data = await fetch(
          `/api/equifax/${this.dni}`
        );
        const objeto = await data.json();
        console.log(objeto);
        this.exifax = objeto;
        console.log(this.exifax.datosConsultas[0].calificacion);
      } catch (error) {
        console.log(error);
      }
    },

    ocultarDashboard(){
      if (this.dni.trim() === '') {
        console.log('ingrese un dni');
        alert('Ingrese DNI')
        return;
      }
      this.ocultar = true;
      const recaptchaScript = document.createElement('script')
      recaptchaScript.setAttribute('src', '/js/dash.js')
      document.head.appendChild(recaptchaScript)
      chart.dispose();
      this.dni= '';
    }

  },
  mounted() {
    const recaptchaScript = document.createElement('script')
      recaptchaScript.setAttribute('src', '/js/dash.js')
      document.head.appendChild(recaptchaScript)
      chart.dispose();
  },

  created() {
    this.Apiequifax();
  },

})