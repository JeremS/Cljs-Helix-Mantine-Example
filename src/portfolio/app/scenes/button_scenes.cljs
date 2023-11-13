(ns app.scenes.button-scenes
  (:require
    [applied-science.js-interop :as j]
    [helix.core :as hc :refer [$]]
    [helix.dom :as d]
    [helix.hooks :as h]
    [portfolio.react-18 :refer-macros [defscene]]
    ["@mantine/core" :as mt]))


(defscene simple-button
  ($ mt/MantineProvider
     ($ mt/Button "click me!!!")))

