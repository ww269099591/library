Vue.component('input-number',{
    template:'\
    <div class="input-number">\
    \
    </div>',
    props:{
        max:{
            type:Number,
            default:Infinity
        },
        min:{
            Type:Number,
            default:-Infinity
        },
        value:{
            type:Number,
            default:0
        }
    }
});

