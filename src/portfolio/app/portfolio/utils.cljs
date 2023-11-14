(ns app.portfolio.utils
  (:require
    [app.lib :refer [defnc]]
    [applied-science.js-interop :as j]
    [helix.core :as hc :refer [$]]
    ["@mantine/core" :as mt]))



(defn get-root-element []
  (some-> (js/document.getElementsByTagName "iframe")
          (.item 0)
          (j/get :contentDocument)
          (.getElementById "canvasRoot")))



(defnc Provider [{cs :children :as props}]
  ($ mt/MantineProvider {:getRootElement get-root-element & props}))
