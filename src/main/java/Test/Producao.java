package main.java.Test;

import main.java.DAO.ConjuntoDAO;
import main.java.DAO.OrgaoDAO;
import main.java.Model.Conjunto;

import static main.java.JSON.JsonManager.jsonToArray;
import static main.java.JSON.JsonManager.readJsonFromUrl;

import main.java.Model.Orgao;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Producao {

    public static void main(String[] args) throws IOException, JSONException, ParseException, InputMismatchException {

        boolean continuar = true;

        Scanner entrada = new Scanner(System.in);
        BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.println("\nEscolha o que deseja inserir: \n");
            System.out.println("\t1. Orgão");
            System.out.println("\t2. Conjunto de dados");
            System.out.println("\t3. Sair");

            System.out.print("\nInsira sua opção: ");
            int opcao = entrada.nextInt();

            if (opcao == 1) {
                String nome;
                String sigla;
                String descricao;
                String tag;

                System.out.print("\nInsira o nome do orgão: ");
                nome = entrada2.readLine();
                System.out.print("Insira a sigla do orgão: ");
                sigla = entrada2.readLine();
                System.out.print("Insira a descrição do orgão: ");
                descricao = entrada2.readLine();
                System.out.print("Insira o tipo do orgão: ");
                tag = entrada2.readLine();

                Orgao orgao = new Orgao();
                OrgaoDAO dao = new OrgaoDAO();

                orgao.setNome(nome);
                orgao.setSigla(sigla);
                orgao.setDescricao(descricao);
                orgao.setTag(tag);

                dao.adiciona(orgao);

                System.out.println("\nOrgão adicionado.\n");

            } else if (opcao == 2) {

                int id_conj = 0;
                int serie;
                String nome;
                String dataset;

                System.out.print("\nInsira um numero de série: ");
                serie = entrada.nextInt();
                System.out.print("Insira o ID do conjunto: ");
                id_conj = entrada.nextInt();
                System.out.print("Insira o nome do conjunto de dados: ");
                nome = entrada2.readLine();
                System.out.print("Insira o dataset: ");
                dataset = entrada2.readLine();

                Conjunto conjunto = new Conjunto();
                ConjuntoDAO dao = new ConjuntoDAO();

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                JSONArray jsonArray = readJsonFromUrl("http://api.bcb.gov.br/dados/serie/bcdata.sgs." + serie + "/dados?formato=json");

                conjunto.setId_conj(id_conj);
                conjunto.setId_org(1);
                conjunto.setSerie(serie);
                conjunto.setNome(nome);
                conjunto.setData_modif(new Date());
                conjunto.setData_ini(formato.parse(jsonArray.getJSONObject(0).get("data").toString()));
                conjunto.setData_final(formato.parse(jsonArray.getJSONObject(jsonArray.length() - 1).get("data").toString()));
                conjunto.setJson(jsonArray.toString());
                conjunto.setDataset(dataset);

                dao.adiciona(conjunto);

                System.out.println("\nConjunto de dados adicionado.\n");

            } else {
                System.out.println("\nTarefa terminada.");
                continuar = false;
            }

        }while(continuar);
    }
}
