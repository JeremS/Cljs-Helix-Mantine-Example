(ns app.portfolio
  (:require
    [portfolio.ui :as ui]
    app.portfolio.scenes.button-scenes
    app.portfolio.scenes.checkbox-scenes))




(ui/start!
  {:config
   {
    :css-paths ["../main.css"]
    :canvas-path "canvas-light.html"}})
    ;:canvas-path "canvas-dark.html"}})


(defn init [])
