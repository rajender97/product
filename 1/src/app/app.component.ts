    import { Component } from '@angular/core';
    import { mobiscroll, MbscListviewOptions } from '../lib/mobiscroll/js/mobiscroll.angular.min.js';
    
    const formatDate = mobiscroll.util.datetime.formatDate;
    const now = formatDate('DD d hh:ii:ss A', new Date());
    
    @Component({
        selector: 'app-root',
        templateUrl: './app.component.html'
    })
    export class AppComponent {
        formSettings = {
            lang: 'en',    // Specify language like: lang: 'pl' or omit setting to use default
            theme: 'ios'   // Specify theme like: theme: 'ios' or omit setting to use default
        };
    
        todo = [{
                text: 'Check Mobiscroll demos',
                time: now
            },
            {
                text: 'Feed the pets',
                time: now
            },
            {
                text: 'Send an invitation email to Emily',
                time: now
            },
            {
                text: 'Watch the new Arrow episode',
                time: now
            },
            {
                text: 'Wash the dishes',
                time: now
            }
        ];
    
        listviewSettings: MbscListviewOptions = {
            theme: 'ios',  // Specify theme like: theme: 'ios' or omit setting to use default
        lang: 'en',
            stages: [{     // More info about stages: https://docs.mobiscroll.com/4-8-5/angular/listview#opt-stages
                percent: -25,
                color: 'red',
                text: 'Delete',
                confirm: true,
                action: (event, inst) => {
                    this.todo.splice(event.index, 1);
                }
            }, {
                percent: 25,
                color: 'green',
                text: 'Update',
                action: (event, inst) => {
                    this.todo[event.index].time = formatDate('DD d hh:ii:ss A', new Date());
                }
            }]
        };
    
        add() {
            mobiscroll.prompt({ 
                
                title: 'New item',
                message: 'Enter a description and add it to the list of existing tasks.',
                placeholder: 'What to do next...',
                callback: (value) => {
                    if (value !== null) {
                        this.todo.push({ text: value ? value : 'New item', time: formatDate('DD d hh:ii:ss A', new Date()) });
                        mobiscroll.toast({ 
                            
                            message: 'New item added'
                        });
                    }
                }
            });
        }
    }
